using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;

namespace S03_Ex03
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

            while (true)
            {
                TcpClient client = listener.AcceptTcpClient();
                Console.WriteLine("Client connected");
                new Thread(() => Run(client)).Start();
            }
        }
        public static void Run(TcpClient client)

        {
            while (true)
            {
                NetworkStream stream = client.GetStream();

                byte[] dataFromClient = new byte[1024];
                int bytesRead = stream.Read(dataFromClient, 0, dataFromClient.Length);
                string s = Encoding.ASCII.GetString(dataFromClient, 0, bytesRead);
                Console.WriteLine(s);
                if (s.ToLower() == "exit")
                {
                    break;
                }

                byte[] dataToClient = Encoding.ASCII.GetBytes($"Returning {s}");
                stream.Write(dataToClient, 0, dataToClient.Length);
            }
            // client.Close();
        }
    }
}