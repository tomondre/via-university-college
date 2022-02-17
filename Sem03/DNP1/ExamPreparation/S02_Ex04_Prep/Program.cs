using System;

namespace S02_04_Prep
{
    class Program
    {
        static void Main(string[] args)
        {
            WaitingRoom wr = new WaitingRoom();

            Patient p1 = new Patient(wr);
            Patient p2 = new Patient(wr);
            Patient p3 = new Patient(wr);
            Patient p4 = new Patient(wr);
            Patient p5 = new Patient(wr);
            
            wr.RunWaitingRoom();
        }
    }
}