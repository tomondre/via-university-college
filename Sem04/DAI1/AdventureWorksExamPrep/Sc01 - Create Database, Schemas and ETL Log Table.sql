---------------------------------------DATABASE CREATION---------------------------------------

CREATE DATABASE AdventureWorksDwh
GO

USE AdventureWorksDwh
GO

---------------------------------------TEST DATABASE CREATION---------------------------------------

--CREATE DATABASE AdventureWorksTestDwh
--GO

--USE AdventureWorksTestDwh
--GO

---------------------------------------SCHEMAS CREATION---------------------------------------
CREATE SCHEMA stage
GO

CREATE SCHEMA edw
GO

CREATE SCHEMA etl
GO

---------------------------------------LOG UPDATE CREATION AND SETUP---------------------------------------

CREATE TABLE etl.LogUpdate(
	[Table] nvarchar(50) NOT NULL,
	LastLoadDate int NOT NULL)

DECLARE @DatabaseCreationDate AS int = 20110530

INSERT INTO etl.LogUpdate ([Table], LastLoadDate) VALUES ('DimCustomer', @DatabaseCreationDate)
INSERT INTO etl.LogUpdate ([Table], LastLoadDate) VALUES ('DimEmployee', @DatabaseCreationDate)
INSERT INTO etl.LogUpdate ([Table], LastLoadDate) VALUES ('DimProduct', @DatabaseCreationDate)
INSERT INTO etl.LogUpdate ([Table], LastLoadDate) VALUES ('FactSale', @DatabaseCreationDate)
