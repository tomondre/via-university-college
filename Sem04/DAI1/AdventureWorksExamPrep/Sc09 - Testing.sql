USE AdventureWorksDwh
GO

---------------------------------------DIM CUSTOMER---------------------------------------

SELECT COUNT(*) AS 'Source Customer Count'
FROM AdventureWorksTest.Sales.Customer

SELECT COUNT(*) AS 'Stage Customer Count'
FROM stage.DimCustomer
  
SELECT COUNT(*) AS 'DW Customer Count'
FROM edw.DimCustomer

---------------------------------------DIM EMPLOYEE---------------------------------------

SELECT COUNT(*) AS 'Source Employee Count'
FROM AdventureWorksTest.Sales.SalesPerson

SELECT COUNT(*) AS 'Stage Employee Count'
FROM stage.DimEmployee
  
SELECT COUNT(*) AS 'DW Employee Count'
FROM edw.DimEmployee

---------------------------------------DIM PRODUCT---------------------------------------

-------------------COUNT-------------------

SELECT COUNT(*) AS 'Source Product Count'
FROM AdventureWorksTest.Production.Product

SELECT COUNT(*) AS 'Stage Product Count'
FROM stage.DimProduct
  
SELECT COUNT(*) AS 'DW Product Count'
FROM edw.DimProduct

---------------------------------------FACT SALE---------------------------------------

SELECT COUNT(*) AS 'Source Sale Count'
FROM AdventureWorksTest.Sales.SalesOrderDetail

SELECT COUNT(*) AS 'Stage Sale Count'
FROM stage.FactSale
  
SELECT COUNT(*) AS 'DW Sale Count'
FROM edw.FactSale

-------------------SUM-------------------

SELECT SUM(LineTotal) AS 'Source Sale Sum'
FROM AdventureWorksTest.Sales.SalesOrderDetail

SELECT SUM(LineTotal) AS 'Source Sale Sum'
FROM AdventureWorksDwh.edw.FactSale