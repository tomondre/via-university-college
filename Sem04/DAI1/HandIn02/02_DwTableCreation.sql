USE [AdventureWorksDwh]
GO

/****** Object:  Schema [edw]    Script Date: 15/03/2022 12.18.13 ******/
CREATE SCHEMA [edw]
GO

CREATE TABLE edw.Dim_Date (
 DId int NOT NULL,
 Date [Datetime] NOT NULL,
 Day int NOT NULL,
 Month int NOT NULL,
 MonthName nvarchar(10) NOT NULL,
 [Week] int NOT NULL,
 Quarter int NOT NULL,
 Year int NOT NULL,
 DayOfWeek int NOT NULL,
 WeekDayName nvarchar(10) NOT NULL,
);

ALTER TABLE edw.Dim_Date ADD CONSTRAINT PK_Dim_Date PRIMARY KEY (DId);


CREATE TABLE edw.Dim_Customer (
 CId int identity NOT NULL,
 CustomerId int NOT NULL,
 Name nvarCHAR(50),
 Type nvarCHAR(50),
 TerritoryCountryName nvarCHAR(50),
 TerritoryGroup nvarCHAR(50)
);

ALTER TABLE edw.Dim_Customer ADD CONSTRAINT PK_Dim_Customer PRIMARY KEY (CId);


CREATE TABLE edw.Dim_Employee (
 EId int identity NOT NULL,
 SalesPersonId int NOT NULL,
 Name nvarCHAR(50),
 TerritoryCountryName nvarCHAR(50),
 Quota float
);

ALTER TABLE edw.Dim_Employee ADD CONSTRAINT PK_Dim_Employee PRIMARY KEY (EId);

CREATE TABLE edw.Dim_Product (
 PId int identity NOT NULL,
 ProductId int NOT NULL,
 Name nvarCHAR(50),
 ProductCategoryName nvarCHAR(50)
);

ALTER TABLE edw.Dim_Product ADD CONSTRAINT PK_Dim_Product PRIMARY KEY (PId);


CREATE TABLE [AdventureWorksDwh].edw.Fact_Sale (
 EId int not null,
 CId int not null,
 PId int not null,
 ShippingDId int not null,
 OrderDId int not null,
 OrderId int not null,
 Qty int,
 TotalLine float
);

ALTER TABLE edw.Fact_Sale ADD CONSTRAINT PK_Fact_Sale PRIMARY KEY (EId, CId,PId,ShippingDId, OrderDId, OrderId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_0 FOREIGN KEY (EId) REFERENCES edw.Dim_Employee (EId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_1 FOREIGN KEY (CId) REFERENCES edw.Dim_Customer (CId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_2 FOREIGN KEY (PId) REFERENCES edw.Dim_Product (PId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_3 FOREIGN KEY (ShippingDId) REFERENCES edw.Dim_Date (DId);
ALTER TABLE edw.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_4 FOREIGN KEY (OrderDId) REFERENCES edw.Dim_Date (DId);