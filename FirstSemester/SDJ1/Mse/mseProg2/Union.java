import java.util.HashSet;
public class Union
{
  public HashSet<String> union(HashSet<String> set1, HashSet<String> set2)
  {
    HashSet<String> set = new HashSet<>();
    boolean isInSet = false;
    for (String str1 : set1)
    {
      set.add(str1);
    }
    for (String str2 : set2)
    {
      for (String str : set)
      {
        if (str.equals(str2))
        {
          isInSet = true;
        }
      }
      if (!isInSet)
      {
        set.add(str2);
      }
      else
      {
        isInSet = false;
      }
    }

    return set;
  }
}
