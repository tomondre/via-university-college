using System;
using System.Threading;

namespace S02_Ex02_Prep
{
    public class Bird
    {
        public string[] Behaviours;
        public Action<string> BirdChange;

        public Bird()
        {
            Behaviours = new[] {"Bird Flaps Wings", "Bird Sings", "Bird Does Mating Dance"};
        }

        public void Run()
        {
            while (true)
            {
                var random = new Random();
                var randomIndex = random.Next(0, Behaviours.Length);

                var behaviour = Behaviours[randomIndex];
                Console.WriteLine($"Bird> {behaviour}");
                BirdChange.Invoke(behaviour);

                var randomTime = random.Next(1000, 5000);
                Thread.Sleep(randomTime);
            }
        }
    }
}