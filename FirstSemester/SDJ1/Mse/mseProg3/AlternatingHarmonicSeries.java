public class AlternatingHarmonicSeries
{

  public double alternatingHarmonicSeries(double n)
  {
    double temp = 0;
    for (int i = 1; i <= n; i++)
    {
    temp += (Math.pow(-1,i+1))/i;
    }

    return temp;
  }
}
