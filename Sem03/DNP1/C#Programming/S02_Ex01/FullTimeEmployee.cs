namespace Ex1
{
    public class FullTimeEmployee : Employee
    {
        public double MonthlySalary { get; set; }

        public override double GetMonthlySalary()
        {
            return MonthlySalary;
        }
    }
}