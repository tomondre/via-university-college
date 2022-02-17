package Ex19_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest
{
  private Queue q;

  @BeforeEach public void setup()
  {
    q = new Queue(6);
  }

  @Test public void enqueueNULL()
  {
    assertThrows(IllegalArgumentException.class, () -> q.enqueue(null));
  }

  @Test public void enqueueOne()
  {
    q.enqueue("A");
    assertEquals(1, q.size());
    assertTrue(q.contains("A"));
  }

  @Test public void enqueueTwo()
  {
    q.enqueue("A");
    q.enqueue("B");
    assertEquals(2, q.size());
  }

  @Test public void enqueue5()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertEquals(5, q.size());
  }

  @Test public void TFirst()
  {
    assertThrows(IllegalStateException.class, () -> q.first());
  }

  @Test public void TFirst1Element()
  {
    q.enqueue("A");
    assertTrue(q.first().equals("A"));
  }

  @Test public void TFirst5Element()
  {
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    q.enqueue("A");
    assertTrue(q.first().equals("B"));
  }

  @Test public void sizeOfQueue()
  {
    assertEquals(0, q.size());
  }

  @Test public void sizeOfQueue1()
  {
    q.enqueue("A");
    assertEquals(1, q.size());
  }

  @Test public void sizeOfQueue5()
  {
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    q.enqueue("A");
    assertEquals(5, q.size());
  }

  @Test public void isEmptyTrue()
  {
    assertTrue(q.isEmpty());
  }

  @Test public void isEmptyFalse()
  {
    q.enqueue("B");
    assertFalse(q.isEmpty());
  }

  @Test public void indexOfAny()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertEquals(3, q.indexOf("D"));
  }

  @Test public void indexOfRepeat()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("B");
    q.enqueue("E");
    assertEquals(1, q.indexOf("B"));
  }

  @Test public void indexOfNotExist()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("B");
    q.enqueue("E");
    assertEquals(-1, q.indexOf("D"));
  }

  @Test public void indexOfEmpty()
  {
    assertEquals(-1, q.indexOf("A"));
  }

  @Test public void containsTrue()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("B");
    q.enqueue("E");
    assertTrue(q.contains("B"));
  }

  @Test public void containsFalse()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    assertFalse(q.contains("D"));
  }

  @Test public void String()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertTrue(q.toString().equals("[A, B, C, D, E]"));
  }

  @Test public void StringNull()
  {
    assertTrue(q.toString().equals("[]"));
  }
}
