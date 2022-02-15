public class RatPopulation2 {

    public int ratPopulation2(double time, double growthRate){
double temp = 1;
      for (int i = 0; i < time; i++)
      {
        temp+= temp * (growthRate-1);
      }
      return (int)temp;
    }
}
