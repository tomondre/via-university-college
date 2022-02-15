using System;
using System.Threading;

namespace S02_04_Prep
{
    public class WaitingRoom
    {
        public Action<int> NumberChange;
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
                currentNumber++;
                Console.WriteLine($"Patient number {currentNumber} can now enter");
                NumberChange.Invoke(currentNumber);
                Thread.Sleep(1000);
            }
        }

        public int DrawNumber()
        {
            return ++ticketCount;
        }
    }
}