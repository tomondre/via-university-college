USE [master]
GO

/****** Object:  Database [AdventureWorksDwh]    Script Date: 28. 2. 2022 15:13:06 ******/
CREATE DATABASE [AdventureWorksDwh]
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AdventureWorksDwh].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [AdventureWorksDwh] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET ARITHABORT OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [AdventureWorksDwh] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [AdventureWorksDwh] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET  DISABLE_BROKER 
GO

ALTER DATABASE [AdventureWorksDwh] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [AdventureWorksDwh] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET RECOVERY FULL 
GO

ALTER DATABASE [AdventureWorksDwh] SET  MULTI_USER 
GO

ALTER DATABASE [AdventureWorksDwh] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [AdventureWorksDwh] SET DB_CHAINING OFF 
GO

ALTER DATABASE [AdventureWorksDwh] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [AdventureWorksDwh] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [AdventureWorksDwh] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [AdventureWorksDwh] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO

ALTER DATABASE [AdventureWorksDwh] SET QUERY_STORE = OFF
GO

ALTER DATABASE [AdventureWorksDwh] SET  READ_WRITE 
GO


USE [AdventureWorksDwh]
GO

/****** Object:  Schema [Stage]    Script Date: 28. 2. 2022 15:14:09 ******/
CREATE SCHEMA [Stage]
GO

CREATE TABLE Stage.Dim_Date (
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

ALTER TABLE Stage.Dim_Date ADD CONSTRAINT PK_Dim_Date PRIMARY KEY (DId);


CREATE TABLE Stage.Dim_Customer (
 CId int identity NOT NULL,
 CustomerId int NOT NULL,
 Name nvarCHAR(50),
 Type nvarCHAR(50),
 TerritoryCountryName nvarCHAR(50),
 TerritoryGroup nvarCHAR(50)
);

ALTER TABLE Stage.Dim_Customer ADD CONSTRAINT PK_Dim_Customer PRIMARY KEY (CId);


CREATE TABLE Stage.Dim_Employee (
 EId int identity NOT NULL,
 SalesPersonId int NOT NULL,
 Name nvarCHAR(50),
 TerritoryCountryName nvarCHAR(50),
 Quota float
);

ALTER TABLE Stage.Dim_Employee ADD CONSTRAINT PK_Dim_Employee PRIMARY KEY (EId);


CREATE TABLE Stage.Dim_Product (
 PId int identity NOT NULL,
 ProductId int NOT NULL,
 Name nvarCHAR(50),
 ProductCategoryName nvarCHAR(50)
);

ALTER TABLE Stage.Dim_Product ADD CONSTRAINT PK_Dim_Product PRIMARY KEY (PId);


CREATE TABLE [AdventureWorksDwh].Stage.Fact_Sale (
SaleId int identity not null,
 EId int,
 CId int,
 PId int ,
 OrderId int,
 EmployeeId int,
 CustomerId int,
 ProductId int,
 ShippingDate [datetime],
 OrderDate [datetime] ,
 Qty bigint,
 TotalLine float
);

ALTER TABLE Stage.Fact_Sale ADD CONSTRAINT PK_Fact_Sale PRIMARY KEY (SaleId);


ALTER TABLE Stage.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_0 FOREIGN KEY (EId) REFERENCES Stage.Dim_Employee (EId);
ALTER TABLE Stage.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_1 FOREIGN KEY (CId) REFERENCES Stage.Dim_Customer (CId);
ALTER TABLE Stage.Fact_Sale ADD CONSTRAINT FK_Fact_Sale_2 FOREIGN KEY (PId) REFERENCES Stage.Dim_Product (PId);




