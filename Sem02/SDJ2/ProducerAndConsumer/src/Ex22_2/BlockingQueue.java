package Ex22_2;

import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class BlockingQueue implements Buffer
{
  private QueueADT queue;

  public BlockingQueue(int capacity)
  {
    queue = new BoundedArrayQueue<>(capacity);
  }

  public synchronized String toString()
  {
    return queue.toString();
  }

  public synchronized int getCapacity()
  {
    return queue.capacity();
  }

  @Override public synchronized void put(Carrot element)
  {
    queue.enqueue(element);
  }

  @Override public synchronized Carrot take()
  {
    return (Carrot) queue.dequeue();
  }

  @Override public synchronized Carrot look()
  {
    return (Carrot) queue.first();
  }

  @Override public synchronized boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public synchronized boolean isFull()
  {
    return queue.isFull();
  }

  @Override public synchronized int size()
  {
    return queue.size();
  }
}
