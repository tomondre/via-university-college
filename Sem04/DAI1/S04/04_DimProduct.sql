USE [AdventureWorksDwh]
GO

DECLARE @OldDate int
SET @OldDate = 20140630

DECLARE @FutureDate int
SET @FutureDate = 99991231

truncate table [Stage].[Dim_Product]

INSERT INTO [Stage].[Dim_Product]
(     [ProductId]
    , [Name]
    , [ProductCategoryName])
select p.ProductID,
       p.Name,
       prod.Name
from AdventureWorks2019.Production.Product p
         left join AdventureWorks2019.Production.ProductSubcategory prod
                   on p.ProductSubcategoryID = prod.ProductSubcategoryID

UPDATE stage.[Dim_Product]
set ProductCategoryName = 'UNKNOWN' where ProductCategoryName is null


INSERT INTO [edw].[Dim_Product]
(     [ProductId]
    , [Name]
    , [ProductCategoryName]
    , [ValidFrom]
    , [ValidTo])
SELECT [ProductId],
       [Name],
       [ProductCategoryName],
       @OldDate,
       @FutureDate

FROM AdventureWorksDwh.Stage.Dim_Product GO