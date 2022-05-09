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



DECLARE @LastLoadDateFactSale datetime
SET @LastLoadDateFactSale = (SELECT [Date]
from AdventureWorksDwh.edw.Dim_Date
where DId in (select MAX([LastLoadDate]) from etl.LogUpdate where [Table] = 'Fact_Sale'))

truncate table [stage].[Fact_sale]
INSERT INTO [AdventureWorksDwh].[Stage].[Fact_Sale]
(     [EmployeeId]
    , [CustomerId]
    , [ProductId]
    , [ShippingDate]
    , [OrderDate]
    , [OrderId]
    , [Qty]
    , [TotalLine])
select case
           when o.SalesPersonID is null
               then -1
           else o.SalesPersonId
           end,
       o.CustomerID,
       saleDetail.ProductID,
       o.ShipDate,
       o.OrderDate,

       saleDetail.SalesOrderID,
       saleDetail.OrderQty,
       saleDetail.OrderQty * saleDetail.UnitPrice * (1 - saleDetail.UnitPriceDiscount)

from AdventureWorks2019.Sales.SalesOrderHeader as o
         join AdventureWorks2019.Sales.SalesOrderDetail as saleDetail
              on o.SalesOrderID = saleDetail.SalesOrderID	  
where o.OrderDate > (@LastLoadDateFactSale)



INSERT INTO AdventureWorksDwh.edw.Fact_Sale
(EId,
 CId,
 PId,
 ShippingDId,
 OrderDId,
 OrderId,
 Qty,
 TotalLine)
SELECT e.EId,
       c.CId,
       p.PId,
       sd.DId,
       od.DId,
       f.OrderId,
       f.Qty,
       f.TotalLine
FROM AdventureWorksDwh.Stage.Fact_Sale as f
         inner join AdventureWorksDwh.edw.Dim_Employee as e
                    on f.EmployeeId = e.SalesPersonId
         inner join AdventureWorksDwh.edw.Dim_Customer as c
                    on f.CustomerId = c.CustomerId
         inner join AdventureWorksDwh.edw.Dim_Product as p
                    on f.ProductId = p.ProductId
         inner join AdventureWorksDwh.edw.Dim_Date as sd
                    on sd.Date = f.ShippingDate
         inner join AdventureWorksDwh.edw.Dim_Date as od
                    on od.Date = f.OrderDate
where p.ValidTo =  @FutureDate
and c.ValidTo =  @FutureDate
and e.ValidTo =  @FutureDate

INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('Dim_Customer', @NewLoadDate)
INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('Dim_Employee', @NewLoadDate)
INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('Dim_Product', @NewLoadDate)
INSERT INTO [etl].[LogUpdate] ([Table], [LastLoadDate])
VALUES ('Fact_Sale', @NewLoadDate)
   
GO
