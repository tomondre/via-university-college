namespace GrpcFileGeneration.Services
{
    public interface IValidator
    {
         bool isValidCvr(int cvr);
         bool isValidPostCode(int post_code);
         bool isValidPassword(string password);
         bool isValidEmail(string email);




    }
}