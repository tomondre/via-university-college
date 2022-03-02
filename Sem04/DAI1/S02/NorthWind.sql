

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[stage].[DimCustomer]') AND type in (N'U'))
CREATE TABLE stage.DimCustomer (
 CustomerId CHAR(10) NOT NULL,
 CompanyName CHAR(10),
 City CHAR(10),
 Region CHAR(10),
 PostalCode CHAR(10),
 Country CHAR(10)
);

ALTER TABLE Dim Customer ADD CONSTRAINT PK_Dim Customer PRIMARY KEY (CustomerId);


CREATE TABLE Dim Employee (
 EmployeeId CHAR(10) NOT NULL,
 EmployeeName CHAR(10),
 Title CHAR(10),
 City CHAR(10),
 Region CHAR(10),
 PostalCode CHAR(10),
 Country CHAR(10)
);

ALTER TABLE Dim Employee ADD CONSTRAINT PK_Dim Employee PRIMARY KEY (EmployeeId);


CREATE TABLE Dim Product (
 ProductId CHAR(10) NOT NULL,
 ProductName CHAR(10),
 SupplierName CHAR(10),
 SupplierId CHAR(10),
 CategoryName CHAR(10),
 CategoryId CHAR(10),
 Discountinued CHAR(10)
);

ALTER TABLE Dim Product ADD CONSTRAINT PK_Dim Product PRIMARY KEY (ProductId);


CREATE TABLE Dim Shipper (
 ShipperId CHAR(10) NOT NULL,
 ShipperName CHAR(10)
);

ALTER TABLE Dim Shipper ADD CONSTRAINT PK_Dim Shipper PRIMARY KEY (ShipperId);


CREATE TABLE Fact Sale (
 OrderId CHAR(10) NOT NULL,
 ProductId CHAR(10) NOT NULL,
 CustomerId CHAR(10) NOT NULL,
 ShipperId CHAR(10) NOT NULL,
 EmployeeId CHAR(10) NOT NULL,
 LineTotal CHAR(10),
 Quantity CHAR(10),
 Discount CHAR(10),
 ShippedDate CHAR(10)
);

ALTER TABLE Fact Sale ADD CONSTRAINT PK_Fact Sale PRIMARY KEY (OrderId,ProductId,CustomerId,ShipperId,EmployeeId);


ALTER TABLE Fact Sale ADD CONSTRAINT FK_Fact Sale_0 FOREIGN KEY (ProductId) REFERENCES Dim Product (ProductId);
ALTER TABLE Fact Sale ADD CONSTRAINT FK_Fact Sale_1 FOREIGN KEY (CustomerId) REFERENCES Dim Customer (CustomerId);
ALTER TABLE Fact Sale ADD CONSTRAINT FK_Fact Sale_2 FOREIGN KEY (ShipperId) REFERENCES Dim Shipper (ShipperId);
ALTER TABLE Fact Sale ADD CONSTRAINT FK_Fact Sale_3 FOREIGN KEY (EmployeeId) REFERENCES Dim Employee (EmployeeId);


