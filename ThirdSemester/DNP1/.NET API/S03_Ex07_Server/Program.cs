using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace S03_Ex07_Server
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Starting server..");

            IPAddress ip = IPAddress.Parse("127.0.0.1");
            TcpListener listener = new TcpListener(ip, 5000);
            listener.Start();

            Console.WriteLine("Server started...");
            List<ServerHandler> serverThreads = new List<ServerHandler>();

            while (true)
            {
                TcpClient client = listener.AcceptTcpClient();
                Console.WriteLine("Client connected");
                ServerHandler handler = new ServerHandler(client, serverThreads);
                serverThreads.Add(handler);
                new Thread(handler.Run).Start();
            }
        }
    }
}