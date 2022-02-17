using System;
using System.Threading;

namespace S02_04
{
    public class WaitingRoom
    {
        public Action<int> NumberChange { get; set; }
        private int currentNumber;
        private int ticketCount;

        public WaitingRoom()
        {
            currentNumber = 0;
            ticketCount = 0;
        }

        public void RunWaitingRoom()
        {
            while (currentNumber < ticketCount)
            {
                NumberChange?.Invoke(currentNumber);
                Console.WriteLine($"Patient with no:{currentNumber++} can enter");
                Thread.Sleep(1000);
            }
        }

        public int DrawNumber()
        {
            return ticketCount++;
        }
    }
}