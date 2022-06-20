USE AdventureWorksDwh
GO

DECLARE @NewLoadDate int
SET @NewLoadDate = CONVERT (CHAR (8), GETDATE(), 112)

DECLARE @FutureDate int
SET @FutureDate = 99991231


DECLARE @LastLoadDateCustomer int
SET @LastLoadDateCustomer = (SELECT MAX([LastLoadDate])
    FROM [etl].[LogUpdate]
    where [Table] = 'DimCustomer')

DECLARE @LastLoadDateEmployee int
SET @LastLoadDateEmployee = (SELECT MAX([LastLoadDate])
    FROM [etl].[LogUpdate]
    where [Table] = 'DimEmployee')

DECLARE @LastLoadDateProduct int
SET @LastLoadDateProduct = (SELECT MAX([LastLoadDate])
    FROM [etl].[LogUpdate]
    where [Table] = 'DimProduct')


--------------------------------DimEmployee--------------------------------

----------------ADDITIONS----------------

INSERT INTO edw.DimEmployee (
	EmployeeID, 
	[Name],
	ValidFrom,
	ValidTo)
SELECT 
	EmployeeID,
	[Name], 
    @NewLoadDate,
    @FutureDate
FROM stage.DimEmployee
WHERE EmployeeID IN (
	SELECT EmployeeID 						-- Everything in stage
    FROM stage.DimEmployee 
	EXCEPT 									-- Except the valid ones in DW
		SELECT EmployeeID
		FROM edw.DimEmployee
		WHERE ValidTo = @FutureDate)

----------------DELETIONS----------------

UPDATE edw.DimEmployee
SET ValidTo=@NewLoadDate - 1
WHERE EmployeeID IN (
	SELECT EmployeeID   					-- Everything in DW
	FROM edw.DimEmployee
	EXCEPT									-- Except the ones in stage
		SELECT EmployeeID
		FROM stage.DimEmployee)
AND ValidTo = @FutureDate
AND EmployeeID != -1

-- Employee with ID -1 represents an internet order employee

----------------CHANGES----------------

DROP TABLE IF EXISTS #tmp1

SELECT 
	EmployeeID,
	[Name]
INTO #tmp1
FROM stage.DimEmployee
EXCEPT										-- Except additions and changes
	SELECT 
		EmployeeID,
		[Name]
	FROM edw.DimEmployee
	WHERE ValidTo = @FutureDate
	EXCEPT									-- Except additions
		SELECT 
			EmployeeID,
			[Name]
		FROM stage.DimEmployee
		WHERE EmployeeID IN 
			(SELECT EmployeeID				-- Select additions
			FROM stage.DimEmployee 
			EXCEPT
				SELECT EmployeeID
				FROM edw.DimEmployee
				WHERE ValidTo = @FutureDate)

-- Insert new rows in dimension
INSERT INTO edw.DimEmployee (EmployeeID,
	[Name], 
	ValidFrom,
    ValidTo
)
SELECT EmployeeID,
	[Name],
	@NewLoadDate,
	@FutureDate
from #tmp1

-- Update the old records to not be valid anymore
UPDATE edw.DimEmployee
SET ValidTo=@NewLoadDate - 1
    WHERE EmployeeID in (
    SELECT EmployeeID
    FROM #tmp1)
    AND edw.DimEmployee.ValidFrom < @NewLoadDate

-- Memory Cleaning
DROP TABLE IF EXISTS #tmp1

--------------------------------DimProduct--------------------------------

----------------ADDITIONS----------------

INSERT INTO edw.DimProduct (
	ProductID,
	[Name],
	Category,
	ValidFrom,
	ValidTo)
SELECT ProductID,
	[Name],
    Category,
	@NewLoadDate,
    @FutureDate
FROM stage.DimProduct
WHERE ProductID IN (
	SELECT ProductID 						-- Everything in stage
    FROM stage.DimProduct 
	EXCEPT 									-- Except the valid ones in DW
		SELECT ProductID
		FROM edw.DimProduct
		WHERE ValidTo = @FutureDate)

----------------DELETIONS----------------
UPDATE edw.DimProduct
SET ValidTo=@NewLoadDate - 1
WHERE ProductID IN (
	SELECT ProductID   						-- Everything in DW
	FROM edw.DimProduct
	WHERE ProductID IN (
		SELECT ProductID
		FROM edw.DimProduct
		EXCEPT								-- Except the ones in stage
			SELECT ProductID
			FROM stage.DimProduct))
AND ValidTo = @FutureDate
AND ProductID != -1

----------------CHANGES----------------

SELECT 
	ProductID,
    [Name],
	Category
INTO #tmp2
FROM stage.DimProduct
EXCEPT										-- Except additions and changes
	SELECT ProductID,
	[Name],
	Category
	FROM edw.DimProduct
	WHERE ValidTo = @FutureDate
	EXCEPT									-- Except additions
		SELECT ProductID,
		[Name],
		Category
		FROM stage.DimProduct
		WHERE ProductID IN (SELECT ProductID
			FROM stage.DimProduct 
			EXCEPT							-- Select additions
				SELECT ProductID
				FROM edw.DimProduct
				WHERE ValidTo = @FutureDate)

-- Insert new rows in dimension
INSERT INTO edw.DimProduct (
	ProductID,
	[Name],
	Category,
	ValidFrom,
	ValidTo)
SELECT ProductID,
	[Name],
    Category,
    @NewLoadDate,
    @FutureDate
from #tmp2

-- Update the old records to not be valid anymore
UPDATE edw.DimProduct
SET ValidTo=@NewLoadDate - 1
WHERE ProductID IN (
	SELECT ProductID
    FROM #tmp2)
    AND edw.DimProduct.ValidFrom < @NewLoadDate

-- Memory Cleaning
DROP TABLE IF EXISTS #tmp2

--------------------------------DimCustomer--------------------------------

----------------ADDITIONS----------------

INSERT INTO edw.DimCustomer (
	CustomerID,
	[Name],
	[Type],
    Country,
	GeographicalLocation,
	ValidFrom,
	ValidTo)
SELECT CustomerID,
	[Name],
	[Type],
    Country,
	GeographicalLocation,
	@NewLoadDate,
    @FutureDate
FROM stage.DimCustomer
WHERE CustomerID IN (
	SELECT CustomerID 						-- Everything in stage
    FROM stage.DimCustomer 
	EXCEPT 									-- Except the valid ones in DW
		SELECT CustomerID
		FROM edw.DimCustomer
		WHERE ValidTo = @FutureDate)

----------------DELETIONS----------------

UPDATE edw.DimCustomer
SET ValidTo=@NewLoadDate - 1
WHERE CustomerID IN (
	SELECT CustomerID   					-- Everything in DW
    FROM edw.DimCustomer
    WHERE CustomerID IN (
		SELECT CustomerID
		FROM edw.DimCustomer
		EXCEPT								-- Except the ones in stage
			SELECT CustomerID
			FROM stage.DimCustomer))
AND ValidTo = @FutureDate
AND CustomerID != -1

----------------CHANGES----------------

SELECT CustomerID,
	[Name],
	[Type],
    Country,
	GeographicalLocation
INTO #tmp3
FROM stage.DimCustomer
EXCEPT										-- Except additions and changes
	SELECT CustomerID,
	[Name],
	[Type],
	Country,
	GeographicalLocation
	FROM edw.DimCustomer
	WHERE ValidTo = @FutureDate
    EXCEPT									-- Except additions
		SELECT CustomerID,
		[Name],
		[Type],
		Country,
		GeographicalLocation
		FROM stage.DimCustomer
		WHERE CustomerID IN (
			SELECT CustomerID
    		FROM stage.DimCustomer 
			EXCEPT							-- Select additions
				SELECT CustomerID
				FROM edw.DimCustomer
				WHERE ValidTo = @FutureDate)

-- Insert new rows in dimension
INSERT INTO edw.DimCustomer (CustomerID,
	[Name],
    [Type],
	Country,
	GeographicalLocation,
    ValidFrom,
    ValidTo)
SELECT CustomerID,
    [Name],
    [Type],
	Country,
	GeographicalLocation,
    @NewLoadDate,
    @FutureDate
from #tmp3

-- Update the old records to not be valid anymore
UPDATE edw.DimCustomer
SET ValidTo=@NewLoadDate - 1
WHERE CustomerID IN (
    SELECT CustomerID
    FROM #tmp3)
AND edw.DimCustomer.ValidFrom < @NewLoadDate

DROP TABLE IF EXISTS #tmp3

--------------------------------FactSale--------------------------------

DECLARE @LastLoadDateFactSale DATETIME
SET @LastLoadDateFactSale = (SELECT [Date]
FROM AdventureWorksDwh.edw.DimDate
where D_ID IN (SELECT MAX([LastLoadDate]) FROM etl.LogUpdate WHERE [Table] = 'FactSale'))

TRUNCATE TABLE stage.FactSale

INSERT INTO AdventureWorksDwh.stage.FactSale(     
	EmployeeID,
	CustomerID,
    ProductID,
	OrderId,
    [Date],
    Quantity,
    LineTotal)
SELECT 
	CASE WHEN h.SalesPersonID IS NULL
		THEN -1
        ELSE h.SalesPersonId
	END,
    h.CustomerID,
    d.ProductID,
	h.SalesOrderID,
    h.OrderDate,
    d.OrderQty,
    d.LineTotal
FROM AdventureWorks2019.Sales.SalesOrderHeader AS h
JOIN AdventureWorks2019.Sales.SalesOrderDetail AS d ON h.SalesOrderID = d.SalesOrderID	  
WHERE h.OrderDate > @LastLoadDateFactSale

INSERT INTO AdventureWorksDwh.edw.FactSale(
	E_ID,
	C_ID,
	P_ID,
	D_ID,
	OrderId,
	Quantity,
	LineTotal)
SELECT e.E_ID,
       c.C_ID,
       p.P_ID,
       CONVERT (CHAR (8), f.[Date], 112),
       f.OrderID,
	   f.Quantity,
       f.LineTotal
FROM AdventureWorksDwh.Stage.FactSale AS f
LEFT JOIN AdventureWorksDwh.edw.DimEmployee AS e ON f.EmployeeID = e.EmployeeID
LEFT JOIN AdventureWorksDwh.edw.DimCustomer AS c ON f.CustomerID = c.CustomerID
LEFT JOIN AdventureWorksDwh.edw.DimProduct AS p ON f.ProductID = p.ProductID
WHERE p.ValidTo = @FutureDate
AND c.ValidTo = @FutureDate
AND e.ValidTo = @FutureDate

--------------------------------Save Load Datea--------------------------------

INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('DimCustomer', @NewLoadDate)
INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('DimEmployee', @NewLoadDate)
INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('DimProduct', @NewLoadDate)
INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('FactSale', @NewLoadDate)