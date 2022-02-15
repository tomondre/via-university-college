package eighth;

import sixth.Bear;
import sixth.PokingMan;

public class Start
{
  public static void main(String[] args)
  {
    Thread bear = new Thread(new Bear());
    Thread pokingMan = new Thread(new PokingMan(bear));

    pokingMan.start();
    bear.start();
    
  }
}
