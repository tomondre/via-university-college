using System;

namespace Ex3
{
    public class Run
    {
        public static void Main(string[] args)
        {
            var person = new Person("Mario");
            
            person.Introduce();
            Console.Write("\n" + person.Name);
        }
    }
}