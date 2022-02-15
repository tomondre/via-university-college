using System;
using System.ComponentModel;

namespace S03_07_Client
{
    public class Message
    {
        public string userName { get; set; }
        public string text { get; set; }
        public DateTime time { get; set; }

        public Message(string userName, string text)
        {
            this.userName = userName;
            this.text = text;
            time = DateTime.Now;
        }

        public override string ToString()
        {
            return $"{userName}-{time.TimeOfDay.ToString()}: {text}";
        }
    }
}