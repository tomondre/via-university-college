using System;

namespace S02_04
{
    class Program
    {
        static void Main(string[] args)
        {
            WaitingRoom waitingRoom = new WaitingRoom();

            new Patient(waitingRoom);
            new Patient(waitingRoom);
            
            waitingRoom.RunWaitingRoom();
        }
    }
}