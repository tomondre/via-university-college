/****** Script for SelectTopNRows command from SSMS  ******/
Use TestSourceDB
go

set identity_insert [Sales].[SalesOrderDetail] on
Insert into [Sales].[SalesOrderDetail]
([SalesOrderID]
      ,[SalesOrderDetailID]
      ,[CarrierTrackingNumber]
      ,[OrderQty]
      ,[ProductID]
      ,[SpecialOfferID]
      ,[UnitPrice]
      ,[UnitPriceDiscount]
      ,[rowguid]
      ,[ModifiedDate])
SELECT [SalesOrderID]
      ,[SalesOrderDetailID]
      ,[CarrierTrackingNumber]
      ,[OrderQty]
      ,[ProductID]
      ,[SpecialOfferID]
      ,[UnitPrice]
      ,[UnitPriceDiscount]
      ,[rowguid]
      ,[ModifiedDate]
  FROM [AdventureWorks2019].[Sales].[SalesOrderDetail]
  set identity_insert [Sales].[SalesOrderDetail] off


  set identity_insert [Sales].[SalesOrderHeader] on
  Insert into  [Sales].[SalesOrderHeader]([SalesOrderID]
      ,[RevisionNumber]
      ,[OrderDate]
      ,[DueDate]
      ,[ShipDate]
      ,[Status]
      ,[OnlineOrderFlag]
      ,[PurchaseOrderNumber]
      ,[AccountNumber]
      ,[CustomerID]
      ,[SalesPersonID]
      ,[TerritoryID]
      ,[BillToAddressID]
      ,[ShipToAddressID]
      ,[ShipMethodID]
      ,[CreditCardID]
      ,[CreditCardApprovalCode]
      ,[CurrencyRateID]
      ,[SubTotal]
      ,[TaxAmt]
      ,[Freight])
  SELECT [SalesOrderID]
      ,[RevisionNumber]
      ,[OrderDate]
      ,[DueDate]
      ,[ShipDate]
      ,[Status]
      ,[OnlineOrderFlag]
      ,[PurchaseOrderNumber]
      ,[AccountNumber]
      ,[CustomerID]
      ,[SalesPersonID]
      ,[TerritoryID]
      ,[BillToAddressID]
      ,[ShipToAddressID]
      ,[ShipMethodID]
      ,[CreditCardID]
      ,[CreditCardApprovalCode]
      ,[CurrencyRateID]
      ,[SubTotal]
      ,[TaxAmt]
      ,[Freight]
      
  FROM [AdventureWorks2019].[Sales].[SalesOrderHeader]
  set identity_insert [Sales].[SalesOrderHeader] off



  set identity_insert [Sales].[Customer] on
  Insert into [Sales].[Customer]([CustomerID]
      ,[PersonID]
      ,[StoreID]
      ,[TerritoryID]
      ,[rowguid]
      ,[ModifiedDate])
  SELECT [CustomerID]
      ,[PersonID]
      ,[StoreID]
      ,[TerritoryID]
      ,[rowguid]
      ,[ModifiedDate]
  FROM [AdventureWorks2019].[Sales].[Customer]
   set identity_insert [Sales].[Customer] off


Insert into [Person].[Person] ([BusinessEntityID]
      ,[PersonType]
      ,[NameStyle]
      ,[Title]
      ,[FirstName]
      ,[MiddleName]
      ,[LastName])
SELECT  [BusinessEntityID]
      ,[PersonType]
      ,[NameStyle]
      ,[Title]
      ,[FirstName]
      ,[MiddleName]
      ,[LastName]
  FROM [AdventureWorks2019].[Person].[Person]



  Insert into [Sales].[Store]
  ([BusinessEntityID]
		,[Name]
      ,[SalesPersonID])
  SELECT [BusinessEntityID]
      ,[Name]
      ,[SalesPersonID]
  FROM [AdventureWorks2019].[Sales].[Store]



  Insert into [Person].[CountryRegion]( [CountryRegionCode]
      ,[Name])
  SELECT  [CountryRegionCode]
      ,[Name]
  FROM [AdventureWorks2019].[Person].[CountryRegion]


  set identity_insert [Sales].[SalesTerritory] on
   Insert into [Sales].[SalesTerritory]( [TerritoryID]
      ,[Name]
      ,[CountryRegionCode]
      ,[Group]
      ,[SalesYTD]
      ,[SalesLastYear])
   SELECT  [TerritoryID]
      ,[Name]
      ,[CountryRegionCode]
      ,[Group]
      ,[SalesYTD]
      ,[SalesLastYear]
  FROM [AdventureWorks2019].[Sales].[SalesTerritory]
  set identity_insert [Sales].[SalesTerritory] off



   Insert into [Sales].[SalesPerson]( [BusinessEntityID]
      ,[TerritoryID]
      ,[SalesQuota]
      ,[Bonus]
      ,[CommissionPct]
      ,[SalesYTD]
      ,[SalesLastYear])
  SELECT [BusinessEntityID]
      ,[TerritoryID]
      ,[SalesQuota]
      ,[Bonus]
      ,[CommissionPct]
      ,[SalesYTD]
      ,[SalesLastYear]
  FROM [AdventureWorks2019].[Sales].[SalesPerson]


  set identity_insert [Production].[Product] on
   Insert into [Production].[Product]( [ProductID]
      ,[Name]
      ,[ProductNumber]
      ,[MakeFlag]
      ,[FinishedGoodsFlag]
      ,[Color]
      ,[SafetyStockLevel]
      ,[ReorderPoint]
      ,[StandardCost]
      ,[ListPrice]
      ,[Size]
      ,[SizeUnitMeasureCode]
      ,[WeightUnitMeasureCode]
      ,[Weight]
      ,[DaysToManufacture]
      ,[ProductLine]
      ,[Class]
      ,[Style]
      ,[ProductSubcategoryID]
      ,[ProductModelID]
      ,[SellStartDate]
      ,[SellEndDate]
      ,[DiscontinuedDate])
  SELECT  [ProductID]
      ,[Name]
      ,[ProductNumber]
      ,[MakeFlag]
      ,[FinishedGoodsFlag]
      ,[Color]
      ,[SafetyStockLevel]
      ,[ReorderPoint]
      ,[StandardCost]
      ,[ListPrice]
      ,[Size]
      ,[SizeUnitMeasureCode]
      ,[WeightUnitMeasureCode]
      ,[Weight]
      ,[DaysToManufacture]
      ,[ProductLine]
      ,[Class]
      ,[Style]
      ,[ProductSubcategoryID]
      ,[ProductModelID]
      ,[SellStartDate]
      ,[SellEndDate]
      ,[DiscontinuedDate]
     
  FROM [AdventureWorks2019].[Production].[Product]
   set identity_insert [Production].[Product] off



   set identity_insert [Production].[ProductCategory] on
   insert into [Production].[ProductCategory]([ProductCategoryID]
      ,[Name])
   SELECT [ProductCategoryID]
      ,[Name]
     
  FROM [AdventureWorks2019].[Production].[ProductCategory]
  set identity_insert [Production].[ProductCategory] off


  Insert into [HumanResources].[Employee]( [BusinessEntityID]
      ,[NationalIDNumber]
      ,[LoginID]
      ,[OrganizationNode]
      ,[JobTitle]
      ,[BirthDate]
      ,[MaritalStatus]
      ,[Gender]
      ,[HireDate]
      ,[SalariedFlag]
      ,[VacationHours]
      ,[SickLeaveHours]
      ,[CurrentFlag])
  SELECT [BusinessEntityID]
      ,[NationalIDNumber]
      ,[LoginID]
      ,[OrganizationNode]
      ,[JobTitle]
      ,[BirthDate]
      ,[MaritalStatus]
      ,[Gender]
      ,[HireDate]
      ,[SalariedFlag]
      ,[VacationHours]
      ,[SickLeaveHours]
      ,[CurrentFlag]
      
  FROM [AdventureWorks2019].[HumanResources].[Employee]


