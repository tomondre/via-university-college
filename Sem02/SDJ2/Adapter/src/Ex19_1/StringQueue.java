package Ex19_1;

public interface StringQueue
{
  void enqueue(String element);
  String dequeue();
  int size();
  int indexOf(String element);
  boolean isEmpty();
  boolean contains(String element);
  String first();
}
