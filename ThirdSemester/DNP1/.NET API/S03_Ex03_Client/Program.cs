﻿using System;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace S03_Ex03_Client
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Starting client..");

            TcpClient client = new TcpClient("127.0.0.1", 5000);
            NetworkStream stream = client.GetStream();

            Console.WriteLine("Write you message or write 'Exit' for exiting the communication");
            while (true)
            {
                string input = Console.ReadLine();
                byte[] dataToServer = Encoding.ASCII.GetBytes(input);
                stream.Write(dataToServer, 0, dataToServer.Length);

                if (input.ToLower() == "exit")
                {
                    break;
                }
                
                byte[] dataFromServer = new byte[1024];
                int bytesRead = stream.Read(dataFromServer, 0, dataFromServer.Length);
                string response = Encoding.ASCII.GetString(dataFromServer, 0, bytesRead);
                Console.WriteLine(response);
            }

            stream.Close();
            client.Close();
        }
    }
}