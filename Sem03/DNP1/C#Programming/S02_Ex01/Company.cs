using System.Collections;
using System.Collections.Generic;

namespace Ex1
{
    public class Company
    {
        private readonly List<Employee> Employees;

        public Company()
        {
            Employees = new List<Employee>();
        }

        public double GetMonthlySalaryTotal()
        {
            double sum = 0;
            Employees.ForEach((a) => sum += a.GetMonthlySalary());
            return sum;
        }

        public void HireNewEmployee(Employee emp)
        {
            Employees.Add(emp);
        }
    }
}