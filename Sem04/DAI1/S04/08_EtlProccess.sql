DECLARE @NewLoadDate int
SET @NewLoadDate = CONVERT(CHAR(8), GETDATE(), 112)
DECLARE @FutureDate int
SET @FutureDate = 99990101


DECLARE @LastLoadDateCustomer int
SET @LastLoadDateCustomer = (SELECT MAX([LastLoadDate]) FROM [etl].[LogUpdate] where [Table]='Dim_Customer')

DECLARE @LastLoadDateEmployee int
SET @LastLoadDateEmployee = (SELECT MAX([LastLoadDate]) FROM [etl].[LogUpdate] where [Table]='Dim_Employee')

DECLARE @LastLoadDateProduct int
SET @LastLoadDateProduct = (SELECT MAX([LastLoadDate]) FROM [etl].[LogUpdate] where [Table]='Dim_Product')