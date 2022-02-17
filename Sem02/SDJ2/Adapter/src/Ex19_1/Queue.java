package Ex19_1;

import java.util.ArrayList;

public class Queue implements StringQueue
{
  private ArrayList<String> list;
  private int cap;

  public Queue(int cap)
  {
    this.list = new ArrayList<>(cap);
    this.cap = cap;
  }

  @Override public void enqueue(String element)
  {
    if (element == null || !(hasCapacity()))
    {
      throw new IllegalArgumentException();
    }
    else
    {
      list.add(element);
    }
  }

  @Override public String dequeue()
  {
    String s = list.get(0);
    list.remove(s);
    return s;
  }

  @Override public int size()
  {
    return list.size();
  }

  @Override public int indexOf(String element)
  {
    return list.indexOf(element);
  }

  @Override public boolean isEmpty()
  {
    return list.size() == 0;
  }

  @Override public boolean contains(String element)
  {
    return list.contains(element);
  }

  @Override public String first()
  {
    try {
      return list.get(0);
    }
    catch (IndexOutOfBoundsException e )
    {
      throw new IllegalStateException();
    }

  }

  public String toString()
  {
    //    String result = "";
    //
    //    for (String s : list)
    //    {
    //      result += s;
    //    }
    //    return s;

    return list.toString();
  }

  private boolean hasCapacity()
  {
    return list.size() < cap;
  }
}
