CREATE SCHEMA IF NOT EXISTS blood_bank;

SET SCHEMA 'blood_bank';

CREATE DOMAIN cpr AS varchar(10) CHECK ( length(value) = 10 );
CREATE DOMAIN blood_type AS varchar(3) CHECK ( VALUE IN ('0-', '0+', 'B-', 'B+', 'A-', 'A+', 'AB-', 'AB+'));
CREATE DOMAIN amount AS int CHECK ( VALUE BETWEEN 300 AND 600);
CREATE DOMAIN blood_percent AS decimal CHECK ( VALUE BETWEEN 8 and 11);
CREATE DOMAIN position_t AS varchar(15) CHECK ( VALUE IN ('nurse', 'bioanalytic', 'intern'));

CREATE TABLE donor
(
    cpr           cpr,
    name          varchar(50),
    house_number  integer,
    street        varchar(60),
    city          varchar(40),
    postal_code   int,
    phone         varchar(12),
    blood_type    blood_type,
    last_reminder date,
    PRIMARY KEY (cpr)
);

CREATE TABLE next_appointment
(
    date      date,
    time      time,
    donor_cpr cpr,
    PRIMARY KEY (date, donor_cpr),
    FOREIGN KEY (donor_cpr) references donor (cpr) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE blood_donations
(
    id            serial,
    date          date,
    amount        amount,
    blood_percent blood_percent,
    donor_cpr     cpr,
    PRIMARY KEY (id),
    FOREIGN KEY (donor_cpr) references donor (cpr) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE staff
(
    initials     varchar(10),
    cpr          cpr,
    name         varchar(50),
    house_number int,
    street       varchar(60),
    city         varchar(40),
    postal_code  int,
    phone        varchar(12),
    hire_date    date,
    position     position_t,
    PRIMARY KEY (initials)
);

CREATE TABLE managed_by
(
    collected_by_nurse_initials varchar(10),
    donation_id                 int,
    verified_by_nurse_initials  varchar(10),
    CHECK ( collected_by_nurse_initials != verified_by_nurse_initials ),
    PRIMARY KEY (donation_id),
    FOREIGN KEY (collected_by_nurse_initials) references staff (initials) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (donation_id) references blood_donations (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (verified_by_nurse_initials) references staff (initials) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE FUNCTION nurse_check()
    RETURNS TRIGGER
AS
$$
BEGIN
    IF 'nurse' != (SELECT position FROM staff WHERE initials = new.verified_by_nurse_initials) OR
       'nurse' != (SELECT position FROM staff WHERE initials = new.collected_by_nurse_initials) THEN
        RAISE EXCEPTION 'Inserted staff is not Nurse';
    END IF;
    RETURN new;
END;
$$
    LANGUAGE plpgsql;

CREATE TRIGGER appointments_nr_trigger
    BEFORE INSERT OR UPDATE
    ON managed_by
    FOR EACH ROW
EXECUTE PROCEDURE nurse_check();