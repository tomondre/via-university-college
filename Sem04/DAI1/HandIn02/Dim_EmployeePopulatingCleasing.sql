USE [AdventureWorksDwh]
GO


INSERT INTO [Stage].[Dim_Employee]
           ([SalesPersonId]
           ,[Name]
           ,[TerritoryCountryName]
           ,[Quota])
    select
	person.BusinessEntityID,

	CONCAT_WS(' ', person.FirstName,person.MiddleName, person.LastName),

	teritory.CountryRegionCode,
	sales.SalesQuota

	From [AdventureWorks2019].[Sales].[SalesPerson] sales

	LEFT join AdventureWorks2019.HumanResources.Employee as h
	on sales.BusinessEntityID = h.BusinessEntityID

	left join AdventureWorks2019.Person.Person as person
	on person.BusinessEntityID = h.BusinessEntityID

	left join AdventureWorks2019.Sales.SalesTerritory  as teritory
	on sales.TerritoryID = teritory.TerritoryID

GO

UPDATE stage.[Dim_Employee]
set TerritoryCountryName='UNKNOWN'
where TerritoryCountryName is null

UPDATE stage.[Dim_Employee]
set Quota= 0
where Quota is null


