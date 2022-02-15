using System;
using System.Collections.Generic;
using System.Net.Sockets;
using System.Text;

class ServerHandler
    {
        private TcpClient client;
        private List<ServerHandler> servers;
        private NetworkStream stream;
        private int num;
        public ServerHandler(TcpClient client, List<ServerHandler> servers, int num)
        {
            this.num = num;
            this.client = client;
            this.servers = servers;
        }

        private void Broadcast(string message)
        {
            servers.ForEach((handler)=> handler.SendMessage(message));
        }

        public void SendMessage(string message)
        {
            byte[] dataToClient = Encoding.ASCII.GetBytes(message);
            stream.Write(dataToClient, 0, dataToClient.Length);
            Console.WriteLine($"MassageSent {num}");
        }

        public void Run()
        {
            while (true)
            {
                stream = client.GetStream();

                byte[] dataFromClient = new byte[1024];
                int bytesRead = stream.Read(dataFromClient, 0, dataFromClient.Length);
                string s = Encoding.ASCII.GetString(dataFromClient, 0, bytesRead);
                Console.WriteLine(s);
                if (s.ToLower() == "exit")
                {
                    break;
                }

                string toSend = $"Returning {s}";
                Broadcast(toSend);
            }
            client.Close();
        }
    }