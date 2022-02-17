using System;
using System.Collections.Generic;
using System.Net.Sockets;
using System.Text;
using S03_07_Client;

class ServerHandler
{
    private TcpClient client;
    private List<ServerHandler> servers;
    private NetworkStream stream;
    public ServerHandler(TcpClient client, List<ServerHandler> servers)
    {
        this.client = client;
        this.servers = servers;
    }

    private void Broadcast(Message message)
    {
        servers.ForEach((handler) => handler.SendMessage(message));
    }

    public void SendMessage(Message message)
    {
        var toSend = Newtonsoft.Json.JsonConvert.SerializeObject(message);
        byte[] dataToClient = Encoding.ASCII.GetBytes(toSend);
        stream.Write(dataToClient, 0, dataToClient.Length);
    }

    public void Run()
    {
        while (true)
        {
            stream = client.GetStream();

            byte[] dataFromClient = new byte[1024];
            int bytesRead = stream.Read(dataFromClient, 0, dataFromClient.Length);
            string s = Encoding.ASCII.GetString(dataFromClient, 0, bytesRead);
            Message message = Newtonsoft.Json.JsonConvert.DeserializeObject<Message>(s);
            Console.WriteLine(message);
            if (s.ToLower() == "exit")
            {
                break;
            }
            Broadcast(message);
        }

        client.Close();
    }
}