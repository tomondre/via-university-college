namespace Ex1
{
    public class PartTimeEmployee : Employee
    {
        public double HourlyWage { get; set; }
        public int HoursPerMonth { get; set; }


        public override double GetMonthlySalary()
        {
            return HourlyWage * HoursPerMonth;
        }
    }
}