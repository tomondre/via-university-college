
public class HyperharmonicSeries {
    public double hyperharmonicSeries(double n, double p){
    double temp = 0;
        for (int i = 1; i <= n; i++)
        {
            temp+=1/(Math.pow(i,p));
        }

        return temp;
    }
}
