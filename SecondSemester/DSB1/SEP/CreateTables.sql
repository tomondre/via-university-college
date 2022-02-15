create schema DHMS;

set schema 'dhms';

CREATE DOMAIN ssn_t AS BIGINT CHECK (VALUE BETWEEN 1000000000 AND 9999999999);

CREATE DOMAIN gender_t CHAR NOT NULL CHECK (VALUE IN ('F', 'M', 'O'));

CREATE DOMAIN blood_type_t varchar(3) CHECK (VALUE IN ('A+', 'A-', 'B+', 'B-', '0+', '0-', 'AB+', 'AB-'));

CREATE DOMAIN sample_t varchar(10) CHECK ( VALUE IN ('blood', 'stool', 'urine', 'DNA'));

CREATE DOMAIN severity_t integer CHECK ( VALUE BETWEEN 1 AND 5);

CREATE DOMAIN email_t varchar(50) NOT NULL CHECK ( VALUE LIKE '%@%' AND VALUE LIKE '%.%' );

CREATE DOMAIN password_t varchar(14) NOT NULL CHECK ( (char_length(value) BETWEEN 8 AND 14)
    AND VALUE ~ '[A-Z]'
    AND VALUE ~ '[a-z]'
    AND VALUE ~ '[0-9]'
    AND VALUE !~ '#');

create table diagnosis
(
    id             serial,
    severity_level severity_t,
    name           varchar(50),
    description    varchar(200),
    primary key (id, severity_level)
);

create table ward
(
    ward_name   varchar(20),
    room_number integer,
    primary key (ward_name, room_number)
);

create table doctor
(
    ssn              ssn_t primary key,
    f_name           varchar(30),
    mid_name         varchar(20),
    l_name           varchar(30),
    add_street       varchar(50),
    add_no           varchar(10),
    add_zip_code     varchar(15),
    add_city         varchar(20),
    dob              date,
    start_date       date,
    education        varchar(50),
    specialization   varchar(50),
    ward_name        varchar(30),
    room_number      integer,
    email            email_t,
    password         password_t,
    nr_appointments  integer default 0,
    contact_f_name   varchar(30),
    contact_mid_name varchar(20),
    contact_l_name   varchar(30),
    contact_phone    varchar(15),
    foreign key (ward_name, room_number) references ward (ward_name, room_number) on update cascade on delete set null
);

create table nurse
(
    ssn              ssn_t primary key,
    doctor_ssn       ssn_t,
    f_name           varchar(30),
    mid_name         varchar(20),
    l_name           varchar(30),
    add_street       varchar(50),
    add_no           varchar(10),
    add_zip_code     varchar(15),
    add_city         varchar(30),
    dob              date,
    start_date       date,
    education        varchar(50),
    experience       varchar(100),
    email            email_t,
    password         password_t,
    contact_f_name   varchar(30),
    contact_mid_name varchar(20),
    contact_l_name   varchar(30),
    contact_phone    varchar(12),
    foreign key (doctor_ssn) references doctor (ssn) on update cascade on delete set null
);

create table patient
(
    ssn                 ssn_t primary key,
    f_name              varchar(30),
    mid_name            varchar(20),
    l_name              varchar(30),
    add_street          varchar(50),
    add_no              varchar(20),
    add_zip_code        varchar(20),
    add_city            varchar(30),
    dob                 date,
    gender              gender_t,
    blood_type          blood_type_t,
    medical_description text,
    contact_f_name      varchar(30),
    contact_mid_name    varchar(20),
    contact_l_name      varchar(30),
    contact_phone       varchar(12)
);

create table manager
(
    ssn              ssn_t primary key,
    f_name           varchar(30),
    mid_name         varchar(20),
    l_name           varchar(30),
    add_street       varchar(50),
    add_no           varchar(10),
    add_zip_code     varchar(15),
    add_city         varchar(30),
    dob              date,
    start_date       date,
    education        varchar(50),
    position         varchar(20),
    email            email_t,
    password         password_t,
    contact_f_name   varchar(30),
    contact_mid_name varchar(20),
    contact_l_name   varchar(30),
    contact_phone    varchar(12)
);

create table suffer_from
(
    patient_ssn    ssn_t,
    diagnosis_id   int,
    severity_level severity_t,
    date_from      date,
    date_to        date,
    primary key (patient_ssn, diagnosis_id, severity_level, date_from),
    foreign key (patient_ssn) references patient (ssn) on update cascade on delete cascade,
    foreign key (diagnosis_id, severity_level) references diagnosis (id, severity_level) on update cascade on delete cascade
);

create table treats
(
    id             serial primary key,
    medication     varchar(50),
    description    text,
    doctor_ssn     ssn_t,
    patient_ssn    ssn_t,
    diagnosis_id   integer,
    severity_level severity_t,
    foreign key (doctor_ssn) references doctor (ssn) on update cascade on delete set null,
    foreign key (patient_ssn) references patient (ssn) on update cascade on delete cascade,
    foreign key (diagnosis_id, severity_level) references diagnosis (id, severity_level) on update cascade on delete cascade
);

create table sample
(
    sample_id   serial primary key,
    type        sample_t,
    result      text,
    deadline    date,
    priority    integer,
    patient_ssn ssn_t,
    foreign key (patient_ssn) references patient (ssn) on update cascade on delete cascade
);

create table appointed
(
    patient_ssn ssn_t,
    doctor_ssn  ssn_t,
    time_from   timestamp not null,
    time_to     timestamp not null,
    primary key (patient_ssn, doctor_ssn, time_from, time_to),
    foreign key (patient_ssn) references patient (ssn) on update cascade on delete cascade,
    foreign key (doctor_ssn) references doctor (ssn) on update cascade on delete cascade
);


CREATE FUNCTION appointments_nr()
    RETURNS TRIGGER
AS
$$
    DECLARE doc_ssn BIGINT;
BEGIN
    IF tg_op = 'INSERT' THEN
        doc_ssn = new.doctor_ssn;
    ELSIF tg_op = 'DELETE' THEN
        doc_ssn = old.doctor_ssn;
    END IF;

    UPDATE doctor
    SET nr_appointments = (SELECT COUNT(doctor_ssn)
                           FROM appointed
                           WHERE doctor_ssn = doc_ssn AND time_from > CURRENT_DATE)
    WHERE ssn = doc_ssn;
    RETURN new;
END;
$$
    LANGUAGE plpgsql;

CREATE TRIGGER appointments_nr_trigger
    BEFORE INSERT OR DELETE
    ON appointed
    FOR EACH ROW
EXECUTE PROCEDURE appointments_nr();


