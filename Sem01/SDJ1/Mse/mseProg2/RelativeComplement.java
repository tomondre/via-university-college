import java.util.HashSet;

public class RelativeComplement
{
  public HashSet<String> relativeComplement(HashSet<String> set1,
      HashSet<String> set2)
  {
    boolean foundMatch;
    HashSet<String> set = new HashSet<>();
    for (String str1 : set1)
    {

      foundMatch = false;
      for (String str2 : set2)
      {
        if (str1.equals(str2))
        {
          foundMatch = true;
          break;
        }
      }
      if (!foundMatch)
      {
        set.add(str1);
      }
    }
    return set;
  }
}
