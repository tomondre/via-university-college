using System;
using System.Threading;

namespace Ex2
{
    class Program
    {
        static void Main(string[] args)
        {
            Bird bird = new Bird();
            BirdWatcher w1 = new BirdWatcher(1);
            BirdWatcher w2 = new BirdWatcher(2);

            bird.LightChange += w1.ReactToBird;
            bird.LightChange += w2.ReactToBird;

            new Thread(new ThreadStart(bird.Run)).Start();
        }
    }
}