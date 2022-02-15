import java.util.HashSet;

public class SubSet
{
  public boolean isASubSet(HashSet<String> set1, HashSet<String> set2)
  {
    boolean foundMatch = false;
    for (String str1 : set1)
    {

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
        return false;
      }
      else
      {
        foundMatch = false;
      }
    }
    return true;
  }
}
