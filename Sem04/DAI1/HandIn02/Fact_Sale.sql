USE [AdventureWorksDwh]
GO



INSERT INTO [AdventureWorksDwh].[Stage].[Fact_Sale]
           ([EmployeeId]
           ,[CustomerId]
           ,[ProductId]
           ,[ShippingDate]
           ,[OrderDate]
           ,[OrderId]
           ,[Qty]
           ,[TotalLine])
select 
case when o.SalesPersonID is null
then -1
else o.SalesPersonId
end,
o.CustomerID,
saleDetail.ProductID,
o.ShipDate,
o.OrderDate,

saleDetail.SalesOrderID,
saleDetail.OrderQty,
saleDetail.OrderQty*saleDetail.UnitPrice*(1-saleDetail.UnitPriceDiscount)	

from AdventureWorks2019.Sales.SalesOrderHeader as o
left join AdventureWorks2019.Sales.SalesOrderDetail as saleDetail
on o.SalesOrderID = saleDetail.SalesOrderID
  
GO

 update [AdventureWorksDwh].[Stage].[Fact_Sale]
  set CId =( select CId from Stage.Dim_Customer   c
  where  c.CustomerId = Stage.Fact_Sale.CustomerId)

   update [AdventureWorksDwh].[Stage].[Fact_Sale]
  set EId =( select EId from Stage.Dim_Employee   e
  where  e.SalesPersonId = Stage.Fact_Sale.EmployeeId)

    update [AdventureWorksDwh].[Stage].[Fact_Sale]
  set PId =( select PId from Stage.Dim_Product   p
  where  p.ProductId = Stage.Fact_Sale.ProductId)


  ALTER TABLE Stage.Fact_Sale DROP CONSTRAINT FK_Fact_Sale_0

  update [AdventureWorksDwh].[Stage].[Fact_Sale]
  set EId = 0
  where Stage.Fact_Sale.EId is null

  ALTER TABLE Stage.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_0 FOREIGN KEY (EId) REFERENCES Stage.Dim_Employee (EId);


