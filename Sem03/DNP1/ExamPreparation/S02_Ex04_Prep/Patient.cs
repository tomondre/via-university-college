using System;

namespace S02_04_Prep
{
    public class Patient
    {
        private int numberInQueue;
        private WaitingRoom wr;

        public Patient(WaitingRoom wr)
        { 
            numberInQueue = wr.DrawNumber();
            wr.NumberChange += ReactToNumber;
            this.wr = wr;
        }

        public void ReactToNumber(int ticketNumber)
        {
            string message;
            
            if (ticketNumber == numberInQueue)
            {
                message = "I am coming";
                wr.NumberChange -= ReactToNumber;
            }
            else
            {
                message = "Nah, not my number!";
            }
            
            Console.WriteLine($"Patient {numberInQueue}> {message}");
        }
    }
}