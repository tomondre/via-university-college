USE [AdventureWorksDwh]
GO

ALTER TABLE Stage.Fact_Sale DROP CONSTRAINT FK_Fact_Sale_2

truncate table [Stage].[Dim_Product]
ALTER TABLE Stage.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_2 FOREIGN KEY (PId) REFERENCES Stage.Dim_Product (PId);

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

GO


