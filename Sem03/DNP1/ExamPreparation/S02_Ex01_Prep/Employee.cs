using System.Runtime.InteropServices;

namespace S02_Ex01_Prep
{
    public abstract class Employee
    {
        public string Name { get; set; }

        public abstract double GetMonthlySalary();
    }
}