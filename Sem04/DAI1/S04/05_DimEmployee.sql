USE [AdventureWorksDwh]
GO

DECLARE @OldDate int
SET @OldDate = 20140630

DECLARE @FutureDate int
SET @FutureDate = 99991231

truncate table [Stage].[Dim_Employee]

INSERT INTO [Stage].[Dim_Employee]
(     [SalesPersonId]
    , [Name]
    , [TerritoryCountryName]
    , [Quota])
select person.BusinessEntityID,

       CONCAT_WS(' ', person.FirstName, person.MiddleName, person.LastName),

       teritory.CountryRegionCode,
       sales.SalesQuota

From [AdventureWorks2019].[Sales].[SalesPerson] sales
    LEFT join AdventureWorks2019.HumanResources.Employee as h
on sales.BusinessEntityID = h.BusinessEntityID
    left join AdventureWorks2019.Person.Person as person
    on person.BusinessEntityID = h.BusinessEntityID
    left join AdventureWorks2019.Sales.SalesTerritory as teritory
    on sales.TerritoryID = teritory.TerritoryID


UPDATE stage.[Dim_Employee]
set TerritoryCountryName = 'UNKNOWN' where TerritoryCountryName is null

UPDATE stage.[Dim_Employee]
set Quota = 0 where Quota is null



INSERT INTO [edw].[Dim_Employee]
(     [SalesPersonId]
    , [Name]
    , [TerritoryCountryName]
    , [Quota]
    , [ValidFrom]
    , [ValidTo])
SELECT [SalesPersonId]
     , [Name]
     , [TerritoryCountryName]
     , [Quota]
     , @OldDate
     , @FutureDate

FROM AdventureWorksDwh.Stage.Dim_Employee INSERT INTO [edw].[Dim_Employee]
           ([SalesPersonId]
           ,[Name]     
           ,[TerritoryCountryName]
           ,[Quota]
		   ,[ValidFrom]
		   ,[ValidTo])
VALUES (-1, 'Online sale', 'Internet', '0', @OldDate, @FutureDate)
    GO