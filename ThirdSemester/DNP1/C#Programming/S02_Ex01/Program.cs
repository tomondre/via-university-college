using System;

namespace Ex1
{
    class Program
    {
        static void Main(string[] args)
        {
            Company reitanDistribution = new Company();
            Employee tomas = new PartTimeEmployee {HourlyWage = 135, HoursPerMonth = 40};
            reitanDistribution.HireNewEmployee(tomas);
            Console.Write(reitanDistribution.GetMonthlySalaryTotal());
        }
    }
}