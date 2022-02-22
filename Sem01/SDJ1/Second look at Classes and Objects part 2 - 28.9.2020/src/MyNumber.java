public class MyNumber
{
  private int number;

  public MyNumber(int number)
  {
    this.number = number;
  }
  public int getNumber()
  {
    return number;
  }
  public int getFirstDigit()
  {
    //return Integer.parseInt(Integer.toString(number).substring(0, 1));
int a = number;
    while (a>10){
      a = a / 10;
    }
return a;
  }
  public int getLastDigit()
  {
    return Math.abs(number)  %10;
    }
    public boolean isDivisibleBy(int c){
    return Math.abs(number)%c==0?true:false;
    }
    public int numberOfProperDivisors()
    {
int x = 0;
      for (int i = number-1; i >= 1; i--)
      {
        if (number%i==0)
        {
          x++;
        }
      }
    return x;
    }
  public boolean isPrime(){
    return numberOfProperDivisors()==1?true:false;
}
  public String toString()
  {
    return isPrime()?number +" a prime number":String.valueOf(number);
  }
  public MyNumber plus(MyNumber num){
    /*if (num == null)
    {
      return new MyNumber(number);
    }
    else
    {
      return new MyNumber(number + num.number);
    }*/
    return num == null?new MyNumber(number):new MyNumber(number + num.number);
  }
  public boolean isPerfectNumber(){

    int x = 0;
    for (int i = number-1; i >= 1; i--)
    {
      if (number%i==0)
      {
        x = x + i;
        System.out.println(x);
      }
    }
    return number==x;

  }

  public static void main(String[] args){
    MyNumber m1 = new MyNumber(59);
    System.out.println(m1.getFirstDigit());
    System.out.println(m1.getLastDigit());
    System.out.println(m1.isDivisibleBy(3));
    System.out.println(m1.numberOfProperDivisors());
    System.out.println(m1.isPrime());
    System.out.println(m1);
    MyNumber m2 = m1.plus(m1);
    System.out.println(m2);


  }
}

