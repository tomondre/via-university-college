using System;

namespace S02_Ex02_Prep
{
    class Program
    {
        static void Main(string[] args)
        {
            Bird bird = new Bird();

            BirdWatcher birdWatcher = new BirdWatcher();

            bird.BirdChange += birdWatcher.ReactToBird;
            
            bird.Run();
        }
    }
}