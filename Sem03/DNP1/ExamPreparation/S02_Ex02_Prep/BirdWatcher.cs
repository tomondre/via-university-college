using System;

namespace S02_Ex02_Prep
{
    public class BirdWatcher
    {
        public void ReactToBird(string input)
        {
            switch (input)
            {
                case "Bird Flaps Wings":
                    Console.WriteLine($"Bird Watcher> Beautiful {input}");
                    break;
                case "Bird Sings":
                    Console.WriteLine($"Bird Watcher> Beautiful {input}");
                    break;
                case "Bird Does Mating Dance":
                    Console.WriteLine("Bird Watcher> I dont like this dance");
                    break;
            }
        }
    }
}