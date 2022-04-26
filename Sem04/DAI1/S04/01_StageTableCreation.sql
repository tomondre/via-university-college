
/****** Object:  Schema [Stage]    Script Date: 28. 2. 2022 15:14:09 ******/
CREATE SCHEMA [Stage]
GO

CREATE TABLE Stage.Dim_Customer (
 CustomerId int NOT NULL,
 Name nvarCHAR(50),
 Type nvarCHAR(50),
 TerritoryCountryName nvarCHAR(50),
 TerritoryGroup nvarCHAR(50)
);

ALTER TABLE Stage.Dim_Customer ADD CONSTRAINT PK_Dim_Customer PRIMARY KEY (CustomerId);


CREATE TABLE Stage.Dim_Employee (
 SalesPersonId int NOT NULL,
 Name nvarCHAR(50),
 TerritoryCountryName nvarCHAR(50),
 Quota float
);

ALTER TABLE Stage.Dim_Employee ADD CONSTRAINT PK_Dim_Employee PRIMARY KEY (SalesPersonId);


CREATE TABLE Stage.Dim_Product (
 ProductId int NOT NULL,
 Name nvarCHAR(50),
 ProductCategoryName nvarCHAR(50)
);

ALTER TABLE Stage.Dim_Product ADD CONSTRAINT PK_Dim_Product PRIMARY KEY (ProductId);

CREATE TABLE [AdventureWorksDwh].Stage.Fact_Sale (
 EId int,
 CId int,
 PId int,
 OrderId int,
 EmployeeId int,
 CustomerId int,
 ProductId int,
 ShippingDate [datetime],
 OrderDate [datetime],
 Qty bigint,
 TotalLine float
);