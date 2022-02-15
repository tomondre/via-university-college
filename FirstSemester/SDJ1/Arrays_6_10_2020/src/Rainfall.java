public class Rainfall
{

  public static String getMonth(int i)
  {
    switch (i)
    {
      case 0:
        return "January";
      case 1:
        return "February";
      case 2:
        return "March";
      case 3:
        return "April";
      case 4:
        return "May";
      case 5:
        return "Juny";
      case 6:
        return "July";
      case 7:
        return "August";
      case 8:
        return "Septmber";
      case 9:
        return "October";
      case 10:
        return "November";
      default:
        return "December";
    }
  }
  public static void main(String[] args){


    double sum = 0;
    double[] rain = {51,41,41,41,43,54,70,62,62,57,63,5};
    double x = rain[0];
    int month=0;


    for (int i = 0; i < rain.length; i++){
     sum+=rain[i];
   }
    System.out.println("Avarage: "+(sum/ rain.length));
for (int i  = 0;i< rain.length;i++){
  if (x<rain[i]){
    x = rain[i];
    month = i;

  }
}
    System.out.println("Highest was in " + getMonth(month));
    for (int i  = 0;i< rain.length;i++){
      if (x>rain[i]){
        x = rain[i];
        month = i;
      }
    }

    System.out.println("Lowest was in " + getMonth(month));
  }
}
