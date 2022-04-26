USE [AdventureWorksDwh]
GO

truncate table [Stage].[Dim_Product]

INSERT INTO [Stage].[Dim_Product]
           ([ProductId]
           ,[Name]
           ,[ProductCategoryName])
     select
	 p.ProductID,
	 p.Name,
	 prod.Name
	 from AdventureWorks2019.Production.Product p

	 left join AdventureWorks2019.Production.ProductSubcategory prod
	 on p.ProductSubcategoryID = prod.ProductSubcategoryID

	 UPDATE stage.[Dim_Product]
set ProductCategoryName ='UNKNOWN'
where ProductCategoryName is null


INSERT INTO [edw].[Dim_Product]
           ([ProductId]
           ,[Name]     
           ,[ProductCategoryName])
     SELECT
	 [ProductId]
           ,[Name]     
           ,[ProductCategoryName]

	 FROM AdventureWorksDwh.Stage.Dim_Product

GO