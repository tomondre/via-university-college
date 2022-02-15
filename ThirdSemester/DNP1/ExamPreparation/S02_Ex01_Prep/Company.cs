using System;
using System.Collections.Generic;

namespace S02_Ex01_Prep
{
    public class Company
    {
        private IList<Employee> employees;

        public Company()
        {
            employees = new List<Employee>();
        }
        
        public double GetMonthlySalary()
        {
            double sum = 0;
            foreach (var employee in employees)
            {
                sum += employee.GetMonthlySalary();
            }

            return sum;
        }

        public void HireNewEmployee(Employee emp)
        {
            employees.Add(emp);
        }
    }
}