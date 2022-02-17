using System;

namespace Ex2
{
    public class BirdWatcher
    {
        private int watcherNum;
        public BirdWatcher(int num)
        {
            watcherNum = num;
        }

        public void ReactToBird(string sound)
        {
            if (sound == Sounds.getDance())
            {
                Console.WriteLine($"{watcherNum} sees dancing bird");
            }
            else if (sound == Sounds.getFlap())
            {
                Console.WriteLine($"{watcherNum} sees flapping bird");
            }
            else
            {
                Console.WriteLine($"{watcherNum} sees singing bird");
            }
        }
    }
}