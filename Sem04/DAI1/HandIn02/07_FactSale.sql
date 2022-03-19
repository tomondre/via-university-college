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
  set CId =( select CId from [AdventureWorksDwh].edw.Dim_Customer   c
  where  c.CustomerId = Stage.Fact_Sale.CustomerId)

  update [AdventureWorksDwh].[Stage].[Fact_Sale]
  set EId =( select EId from [AdventureWorksDwh].edw.Dim_Employee   e
  where  e.SalesPersonId = Stage.Fact_Sale.EmployeeId)

  update [AdventureWorksDwh].[Stage].[Fact_Sale]
  set PId =( select PId from [AdventureWorksDwh].edw.Dim_Product   p
  where  p.ProductId = Stage.Fact_Sale.ProductId)

  update [AdventureWorksDwh].[Stage].[Fact_Sale]
  set EId = 0
  where Stage.Fact_Sale.EId is null
  
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