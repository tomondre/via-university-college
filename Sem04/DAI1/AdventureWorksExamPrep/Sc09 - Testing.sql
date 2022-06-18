USE AdventureWorksDwh
GO

---------------------------------------DIM CUSTOMER---------------------------------------

SELECT COUNT(*)
FROM AdventureWorks2019.Sales.Customer

SELECT COUNT(*)
FROM stage.DimCustomer
  
SELECT COUNT(*)
FROM edw.DimCustomer

---------------------------------------DIM EMPLOYEE---------------------------------------

SELECT COUNT(*)
FROM AdventureWorks2019.Sales.SalesPerson

SELECT COUNT(*)
FROM stage.DimEmployee
  
SELECT COUNT(*)
FROM edw.DimEmployee

---------------------------------------DIM PRODUCT---------------------------------------

SELECT COUNT(*)
FROM AdventureWorks2019.Production.Product

SELECT COUNT(*)
FROM stage.DimProduct
  
SELECT COUNT(*)
FROM edw.DimProduct

---------------------------------------FACT SALE---------------------------------------

SELECT COUNT(*)
FROM AdventureWorks2019.Sales.SalesOrderDetail

SELECT COUNT(*)
FROM stage.FactSale
  
SELECT COUNT(*)
FROM edw.FactSale

