USE [AdventureWorksDwh]
GO

DECLARE @NewLoadDate int
SET @NewLoadDate = CONVERT (CHAR (8), GETDATE(), 112)

DECLARE @FutureDate int
SET @FutureDate = 99991231


DECLARE @LastLoadDateCustomer int
SET @LastLoadDateCustomer = (SELECT MAX([LastLoadDate])
    FROM [etl].[LogUpdate]
    where [Table] = 'Dim_Customer')

DECLARE @LastLoadDateEmployee int
SET @LastLoadDateEmployee = (SELECT MAX([LastLoadDate])
    FROM [etl].[LogUpdate]
    where [Table] = 'Dim_Employee')

DECLARE @LastLoadDateProduct int
SET @LastLoadDateProduct = (SELECT MAX([LastLoadDate])
    FROM [etl].[LogUpdate]
    where [Table] = 'Dim_Product')


--------------------------------Dim_Employee--------------------------------
----------------ADDITIONS----------------
INSERT INTO [edw].[Dim_Employee] ([SalesPersonId]
    , [Name]
    , [TerritoryCountryName]
    , [Quota]
    , [ValidFrom]
    , [ValidTo])
SELECT [SalesPersonId]
     , [Name]
     , [TerritoryCountryName]
     , [Quota]
     , @NewLoadDate
     , @FutureDate
FROM [stage].Dim_Employee
WHERE SalesPersonId in (SELECT [SalesPersonId]
    FROM [Stage].[Dim_Employee] EXCEPT
    SELECT [SalesPersonId]
    FROM [edw].[Dim_Employee]
    WHERE ValidTo = @FutureDate)

----------------DELETIONS----------------
UPDATE [edw].[Dim_Employee]
SET ValidTo=@NewLoadDate - 1
    WHERE SalesPersonId in (
    SELECT [SalesPersonId]
    FROM [edw].[Dim_Employee]
    WHERE [SalesPersonId] in (
    SELECT [SalesPersonId]
    FROM [edw].[Dim_Employee]
    EXCEPT
    SELECT [SalesPersonId]
    FROM [Stage].[Dim_Employee]))
    and ValidTo = @FutureDate
    and SalesPersonId != -1

----------------CHANGES----------------

DROP TABLE IF EXISTS #tmp1

SELECT [SalesPersonId]
     , [Name]
     , [TerritoryCountryName]
     , [Quota]
INTO #tmp1
FROM [Stage].[Dim_Employee]
    EXCEPT
SELECT [SalesPersonId]
     , [Name]
     , [TerritoryCountryName]
     , [Quota]
FROM [edw].[Dim_Employee]
WHERE [ValidTo] = @FutureDate
    EXCEPT
SELECT [SalesPersonId]
     , [Name]
     , [TerritoryCountryName]
     , [Quota]
FROM [Stage].[Dim_Employee]
WHERE [SalesPersonId] in (SELECT [SalesPersonId]
    FROM [Stage].[Dim_Employee] EXCEPT
    SELECT [SalesPersonId]
    FROM [edw].[Dim_Employee]
    WHERE ValidTo = @FutureDate)
INSERT INTO [edw].[Dim_Employee] ([SalesPersonId]
    , [Name]
    , [TerritoryCountryName]
    , [Quota]
    , [ValidFrom]
    , [ValidTo])
SELECT [SalesPersonId]
     , [Name]
     , [TerritoryCountryName]
     , [Quota]
     , @NewLoadDate
     , @FutureDate
from #tmp1

UPDATE [edw].[Dim_Employee]
SET ValidTo=@NewLoadDate - 1
    WHERE [SalesPersonId] in (
    SELECT [SalesPersonId]
    FROM #tmp1)
    AND [edw].[Dim_Employee].ValidFrom < @NewLoadDate

DROP TABLE IF EXISTS #tmp1


--------------------------------Dim_Product--------------------------------
----------------ADDITIONS----------------
INSERT INTO [edw].[Dim_Product] ([ProductId]
    , [Name]
    , [ProductCategoryName]
    , [ValidFrom]
    , [ValidTo])
SELECT [ProductId]
     , [Name]
     , [ProductCategoryName]
     , @NewLoadDate
     , @FutureDate
FROM [stage].Dim_Product
WHERE ProductId in (SELECT [ProductId]
    FROM [Stage].[Dim_Product] EXCEPT
    SELECT [ProductId]
    FROM [edw].[Dim_Product]
    WHERE ValidTo = @FutureDate)

----------------DELETIONS----------------
UPDATE [edw].[Dim_Product]
SET ValidTo=@NewLoadDate - 1
    WHERE ProductId in (
    SELECT [ProductId]
    FROM [edw].[Dim_Product]
    WHERE [ProductId] in (
    SELECT [ProductId]
    FROM [edw].[Dim_Product]
    EXCEPT
    SELECT [ProductId]
    FROM [Stage].[Dim_Product]))
    and ValidTo = @FutureDate
    and ProductId != -1

----------------CHANGES----------------

SELECT [ProductId]
     , [Name]
     , [ProductCategoryName]
INTO #tmp2
FROM [Stage].[Dim_Product]
    EXCEPT
SELECT [ProductId]
     , [Name]
     , [ProductCategoryName]
FROM [edw].[Dim_Product]
WHERE [ValidTo] = @FutureDate
    EXCEPT
SELECT [ProductId]
     , [Name]
     , [ProductCategoryName]
FROM [Stage].[Dim_Product]
WHERE [ProductId] in (SELECT [ProductId]
    FROM [Stage].[Dim_Product] EXCEPT
    SELECT [ProductId]
    FROM [edw].[Dim_Product]
    WHERE ValidTo = @FutureDate)

INSERT INTO [edw].[Dim_Product] ([ProductId]
    , [Name]
    , [ProductCategoryName]
    , [ValidFrom]
    , [ValidTo])
SELECT [ProductId]
     , [Name]
     , [ProductCategoryName]
     , @NewLoadDate
     , @FutureDate
from #tmp2

UPDATE [edw].[Dim_Product]
SET ValidTo=@NewLoadDate - 1
    WHERE [ProductId] in (
    SELECT [ProductId]
    FROM #tmp2)
    AND [edw].[Dim_Product].ValidFrom < @NewLoadDate

DROP TABLE IF EXISTS #tmp2


--------------------------------Dim_Customer--------------------------------
----------------ADDITIONS----------------
INSERT INTO [edw].[Dim_Customer] ([CustomerId]
    , [Name]
    , [Type]
    , [TerritoryCountryName]
    , [TerritoryGroup]
    , [ValidFrom]
    , [ValidTo])
SELECT [CustomerId]
     , [Name]
     , [Type]
     , [TerritoryCountryName]
     , [TerritoryGroup]
     , @NewLoadDate
     , @FutureDate
FROM [stage].Dim_Customer
WHERE CustomerId in (SELECT [CustomerId]
    FROM [Stage].[Dim_Customer] EXCEPT
    SELECT [CustomerId]
    FROM [edw].[Dim_Customer]
    WHERE ValidTo = @FutureDate)

----------------DELETIONS----------------
UPDATE [edw].[Dim_Customer]
SET ValidTo=@NewLoadDate - 1
    WHERE CustomerId in (
    SELECT [CustomerId]
    FROM [edw].[Dim_Customer]
    WHERE [CustomerId] in (
    SELECT [CustomerId]
    FROM [edw].[Dim_Customer]
    EXCEPT
    SELECT [CustomerId]
    FROM [Stage].[Dim_Customer]))
    and ValidTo = @FutureDate
    and CustomerId != -1

----------------CHANGES----------------

SELECT [CustomerId]
     , [Name]
     , [Type]
     , [TerritoryCountryName]
     , [TerritoryGroup]
INTO #tmp3
FROM [Stage].[Dim_Customer]
    EXCEPT
SELECT [CustomerId]
     , [Name]
     , [Type]
     , [TerritoryCountryName]
     , [TerritoryGroup]
FROM [edw].[Dim_Customer]
WHERE [ValidTo] = @FutureDate
    EXCEPT
SELECT [CustomerId]
     , [Name]
     , [Type]
     , [TerritoryCountryName]
     , [TerritoryGroup]
FROM [Stage].[Dim_Customer]
WHERE [CustomerId] in (SELECT [CustomerId]
    FROM [Stage].[Dim_Customer] EXCEPT
    SELECT [CustomerId]
    FROM [edw].[Dim_Customer]
    WHERE ValidTo = @FutureDate)

INSERT INTO [edw].[Dim_Customer] ([CustomerId]
    , [Name]
    , [Type]
    , [TerritoryCountryName]
    , [TerritoryGroup]
    , [ValidFrom]
    , [ValidTo])
SELECT [CustomerId]
     , [Name]
     , [Type]
     , [TerritoryCountryName]
     , [TerritoryGroup]
     , @NewLoadDate
     , @FutureDate
from #tmp3

UPDATE [edw].[Dim_Customer]
SET ValidTo=@NewLoadDate - 1
    WHERE [CustomerId] in (
    SELECT [CustomerId]
    FROM #tmp3)
    AND [edw].[Dim_Customer].ValidFrom < @NewLoadDate

DROP TABLE IF EXISTS #tmp3


INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('Dim_Customer', @NewLoadDate)
INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('Dim_Employee', @NewLoadDate)
INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('Dim_Product', @NewLoadDate)