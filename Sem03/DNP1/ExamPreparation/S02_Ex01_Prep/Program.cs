using System;
using System.Net.Http.Headers;

namespace S02_Ex01_Prep
{
    class Program
    {
        static void Main(string[] args)
        {
            Employee partTimer = new PartTimeEmployee(10, 10);
            Employee fullTimer = new FullTimeEmployee(1000);

            Company company = new Company();
            company.HireNewEmployee(partTimer);
            company.HireNewEmployee(fullTimer);

            var monthlySalary = company.GetMonthlySalary();
            
            //Expected monthly salary 1100
            Console.WriteLine($"Monthly Salary is {monthlySalary}");
        }
    }
}