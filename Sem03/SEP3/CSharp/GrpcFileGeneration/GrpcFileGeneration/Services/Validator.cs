using System.Text.RegularExpressions;

namespace GrpcFileGeneration.Services
{
    public class Validator:IValidator
    {
        public Validator()
        {
        }

        public bool isValidCvr(int cvr)
        {
            return cvr is >= 10000000 and <= 99999999;
        }
        
        public bool isValidPostCode(int post_code)
        {
            return post_code is >= 1000 and <= 9999;
        }
        
        public bool isValidPassword(string password)
        {
            Regex regex = new Regex(@"^(?=.*?[A-Z])(?=.*?[a-z]).{8,14}$");
            Match match = regex.Match(password);
            return match.Success;
        }
        
        public bool isValidEmail(string email)
        {
            Regex regex = new Regex( @"^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}" +
                                     @"\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\" + 
                                     @".)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$");
            Match match = regex.Match(email);
            return match.Success;
        }
        
        
    }
    
}