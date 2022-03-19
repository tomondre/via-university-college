USE [AdventureWorksDwh]
GO

INSERT INTO [edw].[Dim_Customer]
           ([CustomerId]
           ,[Name]
           ,[Type]
           ,[TerritoryCountryName]
           ,[TerritoryGroup])
     SELECT
	 CustomerId,
	 [Name],
	 [Type],
	 TerritoryCountryName,
	 TerritoryGroup

	 FROM AdventureWorksDwh.Stage.Dim_Customer
GO

INSERT INTO [edw].[Dim_Employee]
           ([SalesPersonId]
           ,[Name]     
           ,[TerritoryCountryName]
           ,[Quota])
     SELECT
	 [SalesPersonId]
           ,[Name]     
           ,[TerritoryCountryName]
           ,[Quota]

	 FROM AdventureWorksDwh.Stage.Dim_Employee
GO

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



INSERT INTO AdventureWorksDwh.edw.Fact_Sale
			(EId,
			CId,
			PId,
			ShippingDId,
			OrderDId,
			OrderId,
			Qty,
			TotalLine
			)
SELECT
		e.EId,
		c.CId,
		p.PId,
		sd.DId,
		od.DId,

		f.OrderId,
		f.Qty,
		f.TotalLine

FROM AdventureWorksDwh.Stage.Fact_Sale as f

join AdventureWorksDwh.edw.Dim_Employee as e
on e.SalesPersonId = f.EmployeeId
join AdventureWorksDwh.edw.Dim_Customer as c
on  f.CustomerId=c.CustomerId
join AdventureWorksDwh.edw.Dim_Product as p
on  f.ProductId = p.ProductId
join AdventureWorksDwh.edw.Dim_Date as sd
on  sd.Date= f.ShippingDate
join AdventureWorksDwh.edw.Dim_Date as od
on  od.Date = f.OrderDate
			

