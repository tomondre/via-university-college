using System;
using System.Reflection.Emit;
using System.Runtime.Intrinsics.X86;
using System.Threading;

namespace Ex2
{
    public class Bird
    {
        private string[] behaviour;
        public Action<string> LightChange;

        public Bird()
        {
            behaviour = new []{Sounds.getDance(), Sounds.getFlap(), Sounds.getSing()};
        }

        public void Run()
        {
            while (true)
            {
                int randomTime = new Random().Next(3000, 5000);
                int randomSelection = new Random().Next(0, 3);

                string randomSound = behaviour[randomSelection];
                Console.WriteLine($"Bird makes: {randomSound}");
                LightChange?.Invoke(randomSound);
                Thread.Sleep(randomTime);
            }
        }
    }
}