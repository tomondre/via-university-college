USE AdventureWorksDwh
GO

---------------------------------------DIM CUSTOMER---------------------------------------

SELECT COUNT(*) AS 'Source Customer Count'
FROM AdventureWorks2019.Sales.Customer

SELECT COUNT(*) AS 'Stage Customer Count'
FROM stage.DimCustomer
  
SELECT COUNT(*) AS 'DW Customer Count'
FROM edw.DimCustomer

---------------------------------------DIM EMPLOYEE---------------------------------------

SELECT COUNT(*) AS 'Source Employee Count'
FROM AdventureWorks2019.Sales.SalesPerson

SELECT COUNT(*) AS 'Stage Employee Count'
FROM stage.DimEmployee
  
SELECT COUNT(*) AS 'DW Employee Count'
FROM edw.DimEmployee

---------------------------------------DIM PRODUCT---------------------------------------

SELECT COUNT(*) AS 'Source Product Count'
FROM AdventureWorks2019.Production.Product

SELECT COUNT(*) AS 'Stage Product Count'
FROM stage.DimProduct
  
SELECT COUNT(*) AS 'DW Product Count'
FROM edw.DimProduct

---------------------------------------FACT SALE---------------------------------------

SELECT COUNT(*) AS 'Source Sale Count'
FROM AdventureWorks2019.Sales.SalesOrderDetail

SELECT COUNT(*) AS 'Stage Sale Count'
FROM stage.FactSale
  
SELECT COUNT(*) AS 'DW Sale Count'
FROM edw.FactSale

