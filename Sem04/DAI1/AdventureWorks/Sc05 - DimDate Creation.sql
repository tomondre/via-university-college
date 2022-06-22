---------------------------------------DATABASE USE---------------------------------------

USE AdventureWorksDwh
GO

---------------------------------------TEST DATABASE USE---------------------------------------

--USE AdventureWorksTestDwh
--GO

---------------------------------------DATABASE SETUP---------------------------------------

DECLARE @StartDate DATETIME
DECLARE @EndDate DATETIME
SET @StartDate ='1996-01-01'
SET @EndDate = DATEADD(YEAR, 100, GETDATE())

---------------------------------------TABLE CREATION---------------------------------------

CREATE TABLE edw.DimDate(
	D_ID INT PRIMARY KEY NOT NULL,
	[Date] DATETIME,
	[Day] INT NOT NULL,
	[Month] INT NOT NULL,
	[Year] INT NOT NULL,
	[WeekDay] NVARCHAR(20) NOT NULL,
	Season NVARCHAR(20) NOT NULL,
	SeasonIndex INT NOT NULL
)

---------------------------------------ROW GENERATION---------------------------------------

WHILE @StartDate<=@EndDate
BEGIN 
    INSERT INTO edw.[DimDate]
    (
        [D_ID],
		[Date],
        [Day],
        [Month],
        [Year],
        [WeekDay],
        [Season],
		SeasonIndex
    )
SELECT 
    CONVERT(char(8),@StartDate, 112),
	@StartDate,
	DATEPART(day, @StartDate),
	DATEPART(MONTH, @StartDate),
	DATEPART(YEAR, @StartDate),
	DATENAME(WEEKDAY, @StartDate),
	(CASE WHEN MONTH(@StartDate) IN (12, 1, 2) THEN 'Winter'
      WHEN MONTH(@StartDate) IN (3, 4, 5) THEN 'Spring'
      WHEN MONTH(@StartDate) IN (6, 7, 8) THEN 'Summer'
      WHEN MONTH(@StartDate) IN (9, 10, 11) THEN 'Autumn'
	END),
	(CASE WHEN MONTH(@StartDate) IN (12, 1, 2) THEN 4
      WHEN MONTH(@StartDate) IN (3, 4, 5) THEN 1
      WHEN MONTH(@StartDate) IN (6, 7, 8) THEN 2
      WHEN MONTH(@StartDate) IN (9, 10, 11) THEN 3
	END)
        
SET @StartDate=DATEADD(dd, 1, @StartDate)
END
