using System;

namespace S02_04
{
    public class Patient
    {
        private int numberInQueue;
        
        public Patient(WaitingRoom wr)
        {
            numberInQueue = wr.DrawNumber();
            wr.NumberChange += ReactToNumber;
        }

        private void ReactToNumber(int ticketNumber)
        {
            if (ticketNumber == numberInQueue)
            {
                Console.WriteLine($"Patient no {numberInQueue}: I am coming!");
            }
            else
            {
                Console.WriteLine($"Patient no {numberInQueue}: Looks Up!");
                Console.WriteLine($"Patient no {numberInQueue}: Looks Down!");
            }
        }
    }
}