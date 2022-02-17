//package Ex22_1;
//
//import utility.collection.BoundedArrayQueue;
//import utility.collection.QueueADT;
//
//public class BlockingQueue implements Buffer
//{
//  private QueueADT queue;
//
//  public BlockingQueue(int capacity)
//  {
//    queue = new BoundedArrayQueue<>(capacity);
//  }
//
//  public String toString()
//  {
//    return queue.toString();
//  }
//
//  @Override public void put(T element)
//  {
//    queue.enqueue(element);
//  }
//
//  @Override public T take()
//  {
//    return queue.dequeue();
//  }
//
//  @Override public T look()
//  {
//    return queue.first();
//  }
//
//  @Override public boolean isEmpty()
//  {
//    return queue.isEmpty();
//  }
//
//  @Override public boolean isFull()
//  {
//    return queue.isFull();
//  }
//
//  @Override public int size()
//  {
//    return queue.size();
//  }
//}
