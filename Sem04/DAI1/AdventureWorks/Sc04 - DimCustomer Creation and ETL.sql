---------------------------------------DATABASE USE---------------------------------------

USE AdventureWorksDwh
GO

---------------------------------------TEST DATABASE USE---------------------------------------

--USE AdventureWorksTestDwh
--GO

---------------------------------------DATABASE SETUP---------------------------------------

DECLARE @OldDate AS INT = 20110530
DECLARE @FutureDate AS INT = 99991231

---------------------------------------TABLE CREATION---------------------------------------

CREATE TABLE stage.DimCustomer(
	CustomerID INT PRIMARY KEY NOT NULL,
	[Name] NVARCHAR(50),
	[Type] NVARCHAR(15),
	Country NVARCHAR(50),
	GeographicalLocation NVARCHAR(50)
)

CREATE TABLE edw.DimCustomer(
	C_ID INT IDENTITY PRIMARY KEY NOT NULL,
	CustomerID INT NOT NULL,
	[Name] NVARCHAR(50) NOT NULL,
	[Type] NVARCHAR(15) NOT NULL,
	Country NVARCHAR(50) NOT NULL,
	GeographicalLocation NVARCHAR(50),
	ValidFrom INT NOT NULL,
	ValidTo INT NOT NULL
)

---------------------------------------EXTRACT & TRANSFORM---------------------------------------

TRUNCATE TABLE stage.DimCustomer
INSERT INTO stage.DimCustomer(
	CustomerID,
	[Name],
	[Type],
	Country,
	GeographicalLocation
)
SELECT DISTINCT
	c.CustomerID,
	CASE WHEN c.StoreID IS NULL
		THEN CONCAT_WS(' ', p.FirstName, p.LastName)
		ELSE s.[Name]
	END,
	CASE WHEN c.StoreID IS NULL
		THEN 'Individual'
		ELSE 'Wholesale'
	END,
	cr.[Name],
	t.[Name]
FROM AdventureWorks2019.Sales.Customer c
LEFT JOIN AdventureWorks2019.Sales.Store s ON c.StoreID = s.BusinessEntityID
LEFT JOIN AdventureWorks2019.Person.Person p ON c.PersonID = p.BusinessEntityID
JOIN AdventureWorks2019.Sales.SalesTerritory t ON c.TerritoryID = t.TerritoryID
JOIN AdventureWorks2019.Person.CountryRegion cr ON t.CountryRegionCode = cr.CountryRegionCode
--FROM AdventureWorksTest.Sales.Customer c
--LEFT JOIN AdventureWorksTest.Sales.Store s ON c.StoreID = s.BusinessEntityID
--LEFT JOIN AdventureWorksTest.Person.Person p ON c.PersonID = p.BusinessEntityID
--JOIN AdventureWorksTest.Sales.SalesTerritory t ON c.TerritoryID = t.TerritoryID
--JOIN AdventureWorksTest.Person.CountryRegion cr ON t.CountryRegionCode = cr.CountryRegionCode

---------------------------------------LOAD---------------------------------------

TRUNCATE TABLE edw.DimCustomer

INSERT INTO edw.DimCustomer(
	CustomerID,
	[Name],
	[Type],
	Country,
	GeographicalLocation,
	ValidFrom,
	ValidTo
)
SELECT
	CustomerID,
	[Name],
	[Type],
	Country,
	GeographicalLocation,
	@OldDate,
	@FutureDate
FROM stage.DimCustomer

---------------------------------------SAVE LOAD DATE---------------------------------------

INSERT INTO etl.LogUpdate ([Table], LastLoadDate) VALUES ('DimCustomer', CONVERT (CHAR (8), GETDATE(), 112))