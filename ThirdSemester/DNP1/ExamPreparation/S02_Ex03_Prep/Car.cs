namespace S02_Ex03_Prep
{
    public class Car
    {
        public string Color;
        public int EngineSize;
        public int FuelEconomy;

        public Car(string color, int engineSize, int fuelEconomy)
        {
            Color = color;
            EngineSize = engineSize;
            FuelEconomy = fuelEconomy;
        }

        public override string ToString()
        {
            return $"{{'Color' : '{Color}, 'EngineSize' : '{EngineSize}', 'FuelEconomy' : '{FuelEconomy}'}}";
        }
    }
}