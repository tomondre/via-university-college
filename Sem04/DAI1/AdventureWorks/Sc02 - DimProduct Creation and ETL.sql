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

CREATE TABLE stage.DimProduct(
	ProductID int NOT NULL PRIMARY KEY,
	[Name] nvarchar(50),
	Category nvarchar(50)
)

CREATE TABLE edw.DimProduct(
	P_ID int IDENTITY PRIMARY KEY NOT NULL,
	ProductID int NOT NULL,
	[Name] nvarchar(50) NOT NULL,
	Category nvarchar(50) NOT NULL,
	ValidFrom int NOT NULL,
	ValidTo int NOT NULL
)

---------------------------------------EXTRACT---------------------------------------

TRUNCATE TABLE stage.DimProduct

INSERT INTO stage.DimProduct (
	ProductID,
	[Name],
	Category
)
SELECT 
	p.ProductID, 
	p.[Name], 
	c.[Name]
FROM AdventureWorks2019.Production.Product p
LEFT JOIN AdventureWorks2019.Production.ProductSubcategory c ON c.ProductSubcategoryID = p.ProductSubcategoryID
--FROM AdventureWorksTest.Production.Product p
--LEFT JOIN AdventureWorksTest.Production.ProductSubcategory c ON c.ProductSubcategoryID = p.ProductSubcategoryID

---------------------------------------TRANSFORM---------------------------------------

UPDATE stage.DimProduct
SET Category = 'Unknown'
WHERE Category IS NULL

---------------------------------------LOAD---------------------------------------

INSERT INTO edw.DimProduct (
	ProductID,
	[Name],
	Category,
	ValidFrom,
	ValidTo
)
SELECT 
	p.ProductID, 
	p.[Name],
	p.Category,
	@OldDate,
	@FutureDate
FROM stage.DimProduct p

---------------------------------------SAVE LOAD DATE---------------------------------------

INSERT INTO etl.LogUpdate ([Table], LastLoadDate) VALUES ('DimProduct', CONVERT (CHAR (8), GETDATE(), 112))