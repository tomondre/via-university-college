namespace S02_Ex01_Prep
{
    public class PartTimeEmployee : Employee
    {
        public double HourlyWage { get; set; }
        public double HoursPerMonth { get; set; }

        public PartTimeEmployee(double hourlyWage, double hoursPerMonth)
        {
            HourlyWage = hourlyWage;
            HoursPerMonth = hoursPerMonth;
        }
        public override double GetMonthlySalary()
        {
            return HourlyWage * HoursPerMonth;
        }
    }
}