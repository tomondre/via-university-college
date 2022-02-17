using System;
using System.Collections.Generic;
using System.Linq;

namespace S02_Ex03_Prep
{
    class Program
    {
        static void Main(string[] args)
        {
            var cars = CreateCars(10);

            PrintCarsWithColors(cars.ToList(), new string[] {"White"});
        }

        static void PrintCarsWithColors(List<Car> cars, string[] colors)
        {
            var list = cars.FindAll(car =>
            {
                for (int i = 0; i < colors.Length; i++)
                {
                    if (colors[i] == car.Color)
                    {
                        return true;
                    }
                }

                return false;
            });

            PrintCars(list);
        }


        private static void PrintCars(IEnumerable<Car> list)
        {
            var cars = list.ToArray();
            for (int i = 0; i < cars.Length; i++)
            {
                Console.WriteLine(cars[i]);
            }
        }

        static IList<Car> CreateCars(int numberOfCars)
        {
            var colors = new string[] {"Yellow", "White", "Red", "Blue"};
            var engineSizes = new int[] {1000, 2000, 3000, 4000};
            var fuelEconomy = new int[] {5, 6, 7, 9};

            var random = new Random();

            var result = new List<Car>();
            for (int i = 0; i < numberOfCars; i++)
            {
                var randomColorIndex = random.Next(0, colors.Length);
                var randomEngineSizeIndex = random.Next(0, engineSizes.Length);
                var randomFuelEconomyIndex = random.Next(0, fuelEconomy.Length);

                result.Add(new Car(colors[randomColorIndex], engineSizes[randomEngineSizeIndex],
                    fuelEconomy[randomFuelEconomyIndex]));
            }

            return result;
        }
    }
}