using System;
using System.Collections.Generic;

namespace S02_Ex03
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Car> generateCars = CarFactory.GenerateCars(10);
            generateCars.ForEach(Console.WriteLine);

            List<Car> result;
            
            //A
            Console.WriteLine("A Part");
            result = generateCars.FindAll((car) => car.Color == "Yellow" || car.Color == "Green");
            result.ForEach(Console.WriteLine);

            //B
            Console.WriteLine("B Part");
            string[] selectedColors = new[] {"Red", "Yellow"};
            // selectedColors.FindAll(selectedColors)

            //C
            Console.WriteLine("C Part");
            
            //D
            Console.WriteLine("D Part");
            
            //E
            Console.WriteLine("E Part");
            
            //F
            Console.WriteLine("F Part");
        }
    }
}