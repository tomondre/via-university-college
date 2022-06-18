USE AdventureWorksDwh
GO

DECLARE @DefaultInternetOrderEmployeeId INT = -1

---------------------------------------TABLE CREATION---------------------------------------

CREATE TABLE stage.FactSale(
	CustomerID int,
	EmployeeID int,
	ProductID int,
	C_ID int,
	E_ID int,
	P_ID int,
	D_ID int,
	[Date] DateTime,
	LineTotal int,
	Quantity int)

CREATE TABLE edw.FactSale(
	C_ID int FOREIGN KEY REFERENCES edw.DimCustomer(C_ID) NOT NULL,
	E_ID int FOREIGN KEY REFERENCES edw.DimEmployee(E_ID) NOT NULL,
	P_ID int FOREIGN KEY REFERENCES edw.DimProduct(P_ID) NOT NULL,
	D_ID int FOREIGN KEY REFERENCES edw.DimDate(D_ID) NOT NULL,
	LineTotal int,
	Quantity int)

---------------------------------------EXTRACT & TRANSFORM---------------------------------------

TRUNCATE TABLE stage.FactSale

INSERT INTO stage.FactSale(
	CustomerID,
	EmployeeID,
	ProductID,
	[Date],
	LineTotal,
	Quantity

)
SELECT
	h.CustomerID,
	h.SalesPersonID,
	d.ProductID,
	h.OrderDate,
	d.LineTotal,
	d.OrderQty
FROM AdventureWorks2019.Sales.SalesOrderHeader h
LEFT JOIN AdventureWorks2019.Sales.SalesOrderDetail d ON h.SalesOrderID = d.SalesOrderID

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
	LineTotal,
	Quantity)
SELECT
	C_ID,
	E_ID,
	P_ID,
	D_ID,
	LineTotal,
	Quantity
FROM stage.FactSale

---------------------------------------SAVE LOAD DATE---------------------------------------

INSERT INTO etl.LogUpdate ([Table], LastLoadDate) VALUES ('FactSale', CONVERT (CHAR (8), GETDATE(), 112))