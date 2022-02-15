using System;
using System.Net.Sockets;
using System.Text;
using System.Threading;


namespace S03_07_Client
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Starting client..");

            TcpClient client = new TcpClient("127.0.0.1", 5000);
            NetworkStream stream = client.GetStream();
            
            Console.WriteLine("Type your username>");
            string username = Console.ReadLine();
            
            Console.WriteLine("Write you message or write 'Exit' for exiting the communication>");

            new Thread(() =>
            {
                while (true)
                {
                    byte[] dataFromServer = new byte[1024];
                    int bytesRead = stream.Read(dataFromServer, 0, dataFromServer.Length);
                    string response = Encoding.ASCII.GetString(dataFromServer, 0, bytesRead);
                    Message message = Newtonsoft.Json.JsonConvert.DeserializeObject<Message>(response);
                    Console.WriteLine(message);
                }
            }).Start();
            
            while (true)
            {
                string input = Console.ReadLine();
                string json = Newtonsoft.Json.JsonConvert.SerializeObject(new Message(username, input));
                
                byte[] dataToServer = Encoding.ASCII.GetBytes(json);
                stream.Write(dataToServer, 0, dataToServer.Length);

                if (input.ToLower() == "exit")
                {
                    break;
                }
            }

            stream.Close();
            client.Close();
        }
    }
}