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

CREATE TABLE stage.DimEmployee(
	EmployeeID INT NOT NULL PRIMARY KEY,
	[Name] NVARCHAR(50),
)

CREATE TABLE edw.DimEmployee(
	E_ID INT IDENTITY PRIMARY KEY NOT NULL,
	EmployeeID int NOT NULL,
	[Name] NVARCHAR(50) NOT NULL,
	ValidFrom INT NOT NULL,
	ValidTo INT NOT NULL
)

---------------------------------------EXTRACT & TRANSFORM---------------------------------------

INSERT INTO stage.DimEmployee(
	EmployeeID,
	[Name]
)
SELECT 
	e.BusinessEntityID,
	CONCAT_WS(' ', p.FirstName, p.LastName)
FROM AdventureWorks2019.Sales.SalesPerson e
JOIN AdventureWorks2019.HumanResources.Employee hr on e.BusinessEntityID = hr.BusinessEntityID
JOIN AdventureWorks2019.Person.Person p ON p.BusinessEntityID = hr.BusinessEntityID
--FROM AdventureWorksTest.Sales.SalesPerson e
--JOIN AdventureWorksTest.HumanResources.Employee hr on e.BusinessEntityID = hr.BusinessEntityID
--JOIN AdventureWorksTest.Person.Person p ON p.BusinessEntityID = hr.BusinessEntityID
---------------------------------------LOAD---------------------------------------

INSERT INTO edw.DimEmployee(
	EmployeeID,
	[Name],
	ValidFrom,
	ValidTo
)
SELECT 
	e.EmployeeID,
	e.[Name],
	@OldDate,
	@FutureDate
FROM stage.DimEmployee e

INSERT INTO edw.DimEmployee(
	EmployeeID,
	[Name],
	ValidFrom,
	ValidTo
) VALUES (-1, 'Internet Order', @OldDate, @FutureDate)

---------------------------------------SAVE LOAD DATE---------------------------------------

INSERT INTO etl.LogUpdate ([Table], LastLoadDate) VALUES ('DimEmployee', CONVERT (CHAR (8), GETDATE(), 112))