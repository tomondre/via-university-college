import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node<Integer> node;

    @BeforeEach
    void beforeEach() {
        node = new Node<>(1);
    }

    @Test
    void getData() {
        int data = node.getData();

        assertEquals(1, data);
    }

    @Test
    void setData() {
        node.setData(2);
        int data = node.getData();

        assertEquals(2, data);
    }

    @Test
    void getNextNull() {
        Node<Integer> next = node.getNext();

        assertNull(next);
    }

    @Test
    void getNext() {
        node.setNext(new Node<>(3));
        Node<Integer> next = node.getNext();

        assertNotNull(next);
        assertEquals(3, next.getData());
    }

    @Test
    void setNext() {
        node.setNext(new Node<>(3));

        assertNotNull(node.getNext());
    }
}