---------------------------------------DATABASE USE---------------------------------------

USE AdventureWorksDwh
GO

---------------------------------------TEST DATABASE USE---------------------------------------

--USE AdventureWorksTestDwh
--GO

---------------------------------------DATABASE SETUP---------------------------------------

DECLARE @DefaultInternetOrderEmployeeId INT = -1

---------------------------------------TABLE CREATION---------------------------------------

CREATE TABLE stage.FactSale(
	CustomerID INT,
	EmployeeID INT,
	ProductID INT,
	OrderID INT,
	C_ID INT,
	E_ID INT,
	P_ID INT,
	D_ID INT,
	[Date] DATETIME,
	LineTotal NUMERIC(38, 6),
	Quantity INT,
	Profit MONEY)

CREATE TABLE edw.FactSale(
	C_ID INT FOREIGN KEY REFERENCES edw.DimCustomer(C_ID) NOT NULL,
	E_ID INT FOREIGN KEY REFERENCES edw.DimEmployee(E_ID) NOT NULL,
	P_ID INT FOREIGN KEY REFERENCES edw.DimProduct(P_ID) NOT NULL,
	D_ID INT FOREIGN KEY REFERENCES edw.DimDate(D_ID) NOT NULL,
	OrderID INT NOT NULL,
	LineTotal NUMERIC(38, 6) NOT NULL,
	Quantity INT NOT NULL,
	Profit MONEY
	)

ALTER TABLE edw.FactSale ADD CONSTRAINT PK_FactSale PRIMARY KEY (C_ID, E_ID, P_ID, D_ID, OrderID)

---------------------------------------EXTRACT & TRANSFORM---------------------------------------


INSERT INTO stage.FactSale(
	OrderID,
	CustomerID,
	EmployeeID,
	ProductID,
	[Date],
	LineTotal,
	Quantity,
	Profit)
SELECT
	h.SalesOrderID,
	h.CustomerID,
	h.SalesPersonID,
	d.ProductID,
	h.OrderDate,
	d.LineTotal,
	d.OrderQty,
	d.LineTotal - (p.StandardCost * d.OrderQty)
FROM AdventureWorks2019.Sales.SalesOrderHeader h
LEFT JOIN AdventureWorks2019.Sales.SalesOrderDetail d ON h.SalesOrderID = d.SalesOrderID
JOIN AdventureWorks2019.Production.Product p ON p.ProductID = d.ProductID
--FROM AdventureWorksTest.Sales.SalesOrderHeader h
--LEFT JOIN AdventureWorksTest.Sales.SalesOrderDetail d ON h.SalesOrderID = d.SalesOrderID
--JOIN AdventureWorkTest.Production.Product p ON p.ProductID = d.ProductID

---------------------------------------TRANSFORM---------------------------------------

UPDATE stage.FactSale
SET EmployeeID= -1
WHERE EmployeeID IS NULL

UPDATE stage.FactSale
SET C_ID = (
	SELECT C_ID
	FROM edw.DimCustomer c
	WHERE c.CustomerID = stage.FactSale.CustomerID)

UPDATE stage.FactSale
SET E_ID = (
	SELECT E_ID
	FROM edw.DimEmployee e
	WHERE e.EmployeeID = stage.FactSale.EmployeeID)

UPDATE stage.FactSale
SET P_ID = (
	SELECT P_ID
	FROM edw.DimProduct p
	WHERE p.ProductID = stage.FactSale.ProductID)

UPDATE stage.FactSale
SET D_ID = CONVERT (CHAR (8), [Date], 112)

---------------------------------------LOAD---------------------------------------

INSERT INTO edw.FactSale(
	C_ID,
	E_ID,
	P_ID,
	D_ID,
	OrderID,
	LineTotal,
	Quantity,
	Profit)
SELECT
	C_ID,
	E_ID,
	P_ID,
	D_ID,
	OrderID,
	LineTotal,
	Quantity,
	Profit
FROM stage.FactSale

---------------------------------------SAVE LOAD DATE---------------------------------------

INSERT INTO etl.LogUpdate ([Table], LastLoadDate) VALUES ('FactSale', CONVERT (CHAR (8), GETDATE(), 112))