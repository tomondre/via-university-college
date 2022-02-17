CREATE SCHEMA Departments;

SET SCHEMA 'departments';

CREATE TABLE Department(
    departmentID varchar(30) PRIMARY KEY ,
    floorNum int,
    leadBy varchar(20)
);

CREATE TABLE SubDepartment(
    departmentID varchar(30) PRIMARY KEY ,
    parentDepartment varchar(30),
    FOREIGN KEY(departmentID) references Department(departmentID));