using System;
using System.Drawing;

namespace S02_Ex03
{
    public class Car
    {
        public string Color { get; set; }
        public int EngineSize { get; set; }
        public double FuelEconomy { get; set; }

        public Car()
        {
        }

        public override string ToString()
        {
            return $"Color: {Color}, EngineSize: {EngineSize}, FuelEconomy: {FuelEconomy}";
        }
    }
}