public class QuadraticFunction
{
  private double a,b,c,x,D,e,f ;


  public QuadraticFunction(double a, double b, double c)
  {
    this.a = a;
    this.b = b;
    this.c = c;
  }
  public double getA()
  {
    return a;
  }
  public double getB()
  {
    return b;
  }

  public double getC()
  {
    return c;
  }
  public double getValue(double x)
  {
this.x = x;
    return (Math.pow(x,2)*a)+b * x + c;
  }
  public String getRoots()
  {
    D = Math.pow(b,2) - (4 * a * c);
    if (D < 0)
      {
      return "No roots";
      }
    else if (D  >  0)
    {
      e = (-b + Math.sqrt(D))/(2 * a);
      f = (-b - Math.sqrt(D))/(2 * a);
      if (e>f){
        return "Two roots: " + f +" "+ e;
      }
      else {
        return "Two roots: " + e +" "+ f;
      }
    }
    else
    {
      return  "One root:" + -(b/(2 * a));
    }
  }
}
