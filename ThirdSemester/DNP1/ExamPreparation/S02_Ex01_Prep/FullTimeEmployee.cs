namespace S02_Ex01_Prep
{
    public class FullTimeEmployee : Employee
    {
        public double MonthlySalary { get; set; }

        public FullTimeEmployee(double monthlySalary)
        {
            MonthlySalary = monthlySalary;
        }

        public override double GetMonthlySalary()
        {
            return MonthlySalary;
        }
    }
}