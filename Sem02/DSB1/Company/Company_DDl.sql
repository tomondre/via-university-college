CREATE SCHEMA company;

set schema 'company';

CREATE DOMAIN gender_T CHAR NOT NULL CHECK (value in ('F', 'M', 'O'));


CREATE TABLE department(
  d_name varchar(20) unique,
  d_no int PRIMARY KEY ,
  mgr_start_date date
);

CREATE TABLE employee(
    f_name varchar(50),
    m_init char(1),
    l_name varchar(50),
    ssn varchar(9) PRIMARY KEY ,
    dob
)