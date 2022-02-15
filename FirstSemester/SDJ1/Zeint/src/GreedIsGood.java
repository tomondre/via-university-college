import java.util.ArrayList;
import java.util.Scanner;

public class GreedIsGood
{
  private int power;
  private int price;
  private char material;

  public GreedIsGood(int power, int price, char material)
  {
    this.power = power;
    this.price = price;
    this.material = material;
  }

  public int getPower()
  {
    return power;
  }

  public int getPrice()
  {
    return price;
  }

  public char getMaterial()
  {
    return material;
  }

  public int sumOfPower(GreedIsGood hrdina)
  {
    return hrdina.getPower() + getPower();
  }

  public int sumOfPrice(GreedIsGood hrdina)
  {
    return hrdina.getPrice() + getPrice();
  }

  public boolean materialEquals(GreedIsGood hrdina)
  {
    return material == hrdina.getMaterial();
  }

  @Override public String toString()
  {
    return "GreedIsGood{" + "power=" + power + ", price=" + price + ", material="
        + material + '}';
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof GreedIsGood))
    {
      return false;
    }
    GreedIsGood other = (GreedIsGood) obj;
    return materialEquals(other) && price == other.getPrice() && materialEquals(
        other);
  }

  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int hrdinov = keyboard.nextInt();
    int zlato = keyboard.nextInt();
    int drevo = keyboard.nextInt();
    GreedIsGood g1;
    GreedIsGood g2;
    GreedIsGood[] list = new GreedIsGood[hrdinov];
    for (int i = 0; i < hrdinov; i++)
    {
      list[i] = new GreedIsGood(keyboard.nextInt(), keyboard.nextInt(),
          keyboard.next().charAt(0));
    }
    g1 = list[0];
    g2 = list[1];
    ArrayList<GreedIsGood> temp = new ArrayList<GreedIsGood>();
    for (int i = 0; i < hrdinov; i++)
    {
      for (int j = 0; j < hrdinov; j++)
      {
        if (list[i] == list[j])
        {
          continue;
        }
        else if (list[i].materialEquals(list[j]))
        {
          if (list[i].getMaterial() == 'P')
          {
            if ((list[i].sumOfPrice(list[j])) < drevo
                && list[i].sumOfPower(list[j]) > g1.sumOfPower(g2))
            {
              g1 = list[i];
              g2 = list[j];
            }
          }

          if (list[i].getMaterial() == 'E')
          {
            if ((list[i].sumOfPrice(list[j])) < zlato
                && list[i].sumOfPower(list[j]) > g1.sumOfPower(g2))
            {
              g1 = list[i];
              g2 = list[j];
            }
          }
        }

      }
    }
    System.out.println(g1);
    System.out.println(g2);
  }
}
