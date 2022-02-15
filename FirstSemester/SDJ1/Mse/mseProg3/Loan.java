public class Loan
{

    public int loan(double principal, double interest, double nrOfRepayments)
    {
        double temp = principal;
        for (int i = 0; i < nrOfRepayments; i++)
        {
            temp += temp * interest;
        }
        return (int)(temp / nrOfRepayments)+1;
    }
}
