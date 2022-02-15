package Ex22_2;

public interface Buffer
{
  void put(Carrot element);
  Carrot take();
  Carrot look();
  boolean isEmpty();
  boolean isFull();
  int size();
}

