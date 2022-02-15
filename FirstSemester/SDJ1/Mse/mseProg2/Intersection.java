import java.util.HashSet;

public class Intersection
{
  public HashSet<String> intersection(HashSet<String> set1,
      HashSet<String> set2)
  {
    HashSet<String> set = new HashSet<>();

    for (String str1 : set1)
    {

      for (String str2 : set2)
      {
        if (str1.equals(str2))
        {
          set.add(str1);
          break;
        }
      }

    }

    return set;
  }
}
