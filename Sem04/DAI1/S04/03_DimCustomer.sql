USE [AdventureWorksDwh]
GO

DECLARE @OldDate int
SET @OldDate = 20140630

DECLARE @FutureDate int
SET @FutureDate = 99991231


--truncate table [Stage].[Dim_Customer]

INSERT INTO [Stage].[Dim_Customer]
(     [CustomerId]
    , [Name]
    , [Type]
    , [TerritoryCountryName]
    , [TerritoryGroup])

select distinct header.CustomerID,
                case
                    when c.PersonID is not NULL
                        then CONCAT_WS(' ', p.FirstName, p.MiddleName, p.LastName)
                    else [s].[Name]
                    end,

                case
                    when header.OnlineOrderFlag = 0
                        then 'store'
                    else 'private'
                    end,

                region.Name,
                t.[Group]

FROM [AdventureWorks2019].[Sales].[SalesOrderHeader] header
    left join AdventureWorks2019.Sales.Customer as c
on c.CustomerID = header.CustomerID
    LEFT join AdventureWorks2019.Sales.Store as s
    on s.BusinessEntityID = c.StoreID
    left join AdventureWorks2019.Person.Person as p
    on p.BusinessEntityID = c.PersonID
    left join AdventureWorks2019.Sales.SalesTerritory as t
    on t.TerritoryID = c.TerritoryID
    left join AdventureWorks2019.Person.CountryRegion as region
    on region.CountryRegionCode = t.CountryRegionCode


--truncate table [edw].[Dim_Customer]

INSERT INTO [edw].[Dim_Customer]
(     [CustomerId]
    , [Name]
    , [Type]
    , [TerritoryCountryName]
    , [TerritoryGroup]
    , [ValidFrom]
    , [ValidTo])
SELECT CustomerId,
       [Name],
       [Type],
       TerritoryCountryName,
       TerritoryGroup,
       @OldDate,
       @FutureDate

FROM AdventureWorksDwh.Stage.Dim_Customer GO

		  