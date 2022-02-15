using System;
using System.Collections.Generic;
using System.Drawing;

namespace S02_Ex03
{
    public static class CarFactory
    {
        public static List<Car> GenerateCars(int numberOfCars)
        {
            List<string> colors = new List<string>() {"Green", "Yellow", "Red", "Blue"};
            List<int> engineSizes = new List<int>() {1000, 1500, 2000, 2500};
            List<double> fuelEconomy = new List<double>() {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
            List<Car> generatedCars = new List<Car>();

            for (int i = 0; i < numberOfCars; i++)
            {
                Random rnd = new Random();
                string randomColor = colors[rnd.Next(0, 4)];
                int randomEngineSize = engineSizes[rnd.Next(0, 4)];
                double randomFuelEconomy = fuelEconomy[rnd.Next(0, 10)];
                generatedCars.Add(new Car()
                {
                    Color = randomColor,
                    EngineSize = randomEngineSize,
                    FuelEconomy = randomFuelEconomy
                });
            }
            return generatedCars;
        }
    }
}