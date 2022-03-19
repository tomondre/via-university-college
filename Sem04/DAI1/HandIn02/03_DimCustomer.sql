USE [AdventureWorksDwh]
GO

truncate table [Stage].[Dim_Customer]

INSERT INTO [Stage].[Dim_Customer]
           ([CustomerId]
           ,[Name]
           ,[Type]
           ,[TerritoryCountryName]
           ,[TerritoryGroup])
    select
	[CustomerID],
	case when c.PersonID is not NULL
	 then CONCAT_WS(' ', p.FirstName,p.MiddleName, p.LastName)
	 else [s].[Name]
	 end,

	 case when c.PersonID is NULL
	 then 'store'
	 else 'private'
	 end,

	 region.Name,
	 t.[Group]

	FROM [AdventureWorks2019].[Sales].[Customer] c

	  LEFT join AdventureWorks2019.Person.Person as p 
	on p.BusinessEntityID = c.PersonID

	 LEFT join AdventureWorks2019.Sales.Store as s
	on s.BusinessEntityID = c.StoreID

	 LEFT join AdventureWorks2019.Sales.SalesTerritory as t
	on t.TerritoryID = c.TerritoryID

	 LEFT join AdventureWorks2019.Person.CountryRegion as region 
	on region.CountryRegionCode = t.CountryRegionCode


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

