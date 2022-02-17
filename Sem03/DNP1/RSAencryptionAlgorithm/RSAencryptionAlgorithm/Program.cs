using System;

namespace RSAencryptionAlgorithm
{
    class Program
    {
        static void Main(string[] args)
        {
            User alice = new User();
            User bob = new User();
            var cryptMessage = bob.CryptMessage("AB", alice.N, alice.E);
            Console.WriteLine(cryptMessage);

            var decryptMessage = alice.DecryptMessage(cryptMessage);
            Console.WriteLine(decryptMessage);
        }
    }
}