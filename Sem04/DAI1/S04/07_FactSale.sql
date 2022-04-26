USE [AdventureWorksDwh]
GO

truncate table AdventureWorksDwh.stage.Fact_Sale

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
join AdventureWorks2019.Sales.SalesOrderDetail as saleDetail
on o.SalesOrderID = saleDetail.SalesOrderID
  
GO


 

truncate table AdventureWorksDwh.edw.Fact_Sale
  
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

inner join AdventureWorksDwh.edw.Dim_Employee as e
on  f.EmployeeId = e.SalesPersonId

 inner join AdventureWorksDwh.edw.Dim_Customer as c
on  f.CustomerId=c.CustomerId


   inner join AdventureWorksDwh.edw.Dim_Product as p
on  f.ProductId = p.ProductId
  inner join AdventureWorksDwh.edw.Dim_Date as sd
on  sd.Date= f.ShippingDate
  inner join AdventureWorksDwh.edw.Dim_Date as od
on  od.Date = f.OrderDate


--ALTER TABLE edw.Fact_Sale drop CONSTRAINT PK_Fact_Sale 
--ALTER TABLE edw.Fact_Sale drop CONSTRAINT FK_Fact_Sale_0 
--ALTER TABLE edw.Fact_Sale drop CONSTRAINT FK_Fact_Sale_1 
--ALTER TABLE edw.Fact_Sale drop CONSTRAINT FK_Fact_Sale_2 
--ALTER TABLE edw.Fact_Sale drop CONSTRAINT FK_Fact_Sale_3 
--ALTER TABLE edw.Fact_Sale drop CONSTRAINT FK_Fact_Sale_4 
--ALTER TABLE edw.Fact_Sale ALter column CId int NOt NULL
--ALTER TABLE edw.Fact_Sale ALter column PId int not NULL
--ALTER TABLE edw.Fact_Sale ALter column EId int not NULL
--ALTER TABLE edw.Fact_Sale ALter column ShippingDId int not NULL
--ALTER TABLE edw.Fact_Sale ALter column OrderDId int not NULL
--ALTER TABLE edw.Fact_Sale ALter column OrderId int not NULL


ALTER TABLE edw.Fact_Sale ADD CONSTRAINT PK_Fact_Sale PRIMARY KEY (EId, CId,PId,ShippingDId, OrderDId, OrderId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_0 FOREIGN KEY (EId) REFERENCES edw.Dim_Employee (EId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_1 FOREIGN KEY (CId) REFERENCES edw.Dim_Customer (CId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_2 FOREIGN KEY (PId) REFERENCES edw.Dim_Product (PId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_3 FOREIGN KEY (ShippingDId) REFERENCES edw.Dim_Date (DId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_4 FOREIGN KEY (OrderDId) REFERENCES edw.Dim_Date (DId);
