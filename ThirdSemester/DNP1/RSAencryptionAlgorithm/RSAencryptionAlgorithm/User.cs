using System;
using System.Numerics;
using System.Security.Cryptography;

namespace RSAencryptionAlgorithm
{
    public class User
    {
        public int N { get; private set; }
        public int E { get; private set; }
        private int p1 = 53;
        private int p2 = 59;
        private int d;

        public User()
        {
            GenerateKeys();
        }

        private void GenerateKeys()
        {
            E = 3;
            N = p1 * p2;
            d = (2 * phi(N) + 1) / E;
        }

        private int phi(int n)
        {
            int result = n;
            for (int p = 2; p * p <= n; ++p)
            {
                if (n % p == 0)
                {
                    while (n % p == 0)
                        n /= p;
                    result -= result / p;
                }
            }
            if (n > 1)
                result -= result / n;
            return result;
        }

        public int CryptMessage(string plainText, int publicN, int publicE)
        {
            string cipherText = PlainTextToCipherText(plainText);
            long messageLongVersion = Int64.Parse(cipherText);

            return (int)Math.Pow(messageLongVersion, publicE) % publicN;
        }

        private string PlainTextToCipherText(string cipher)
        {
            string result = "";
            for (int i = 0; i < cipher.Length; i++)
            {
                result += charToInt(Char.ToUpper(cipher[i])).ToString();
            }

            return result;
        }

        private string CipherTextToPlainText(string cipherText)
        {
            string result = "";
            for (int i = 0; i < cipherText.Length; i++)
            {
                result += (char) (Int16.Parse(cipherText[i].ToString()) + 64);
            }

            return result;
        }

        private int charToInt(char toConvert)
        {
            return char.ToUpper(toConvert) - 64;
        }

        public string DecryptMessage(int cryptedMessage)
        {
            var value = new BigInteger(cryptedMessage);
            var cipherText = BigInteger.ModPow(value, new BigInteger(d), new BigInteger(N)).ToString();
            return CipherTextToPlainText(cipherText);
        }
    }
}