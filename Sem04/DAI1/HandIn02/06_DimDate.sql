USE [AdventureWorksDwh]
GO

DECLARE @StartDate DATETIME
DECLARE @EndDate DATETIME
SET @StartDate ='1996-01-01'
SET @EndDate = DATEADD(YEAR, 1095, GETDATE())
WHILE @StartDate<=@EndDate
BEGIN 
    INSERT INTO edw.[Dim_Date]
    (
        [DId],
        [Date],
        [Day],
        [Month],
        [MonthName],
        [Week],
        [Quarter],
        [Year],
        [DayOfWeek],
        [WeekDayName]
    )
SELECT 
    CONVERT(char(8),@StartDate, 112) AS D_ID,
        @StartDate AS [Date],
        DATEPART(day, @StartDate) AS Day,
        DATEPART(MONTH, @StartDate) as Month,
        DATENAME(MONTH, @StartDate) as MonthName,
        DATEPART(Week, @StartDate) as Week,
        DATEPART(QUARTER, @StartDate) as Quarter,
        DATEPART(YEAR, @StartDate) as Year,
        DATEPART(WEEKDAY, @StartDate) as DayOfWeek,
        DATENAME(WEEKDAY, @StartDate) as WeekdayName
        
SET @StartDate=DATEADD(dd, 1, @StartDate)
END
GO