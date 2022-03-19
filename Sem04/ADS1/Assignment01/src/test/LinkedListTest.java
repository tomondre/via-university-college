import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> list;


    @BeforeEach
    void beforeEach() {
        list = new LinkedList<>();
    }

    @Test
    void isEmpty() {
        boolean empty = list.isEmpty();

        assertTrue(empty);
    }

    @Test
    void isEmptyNot() {
        list.addToFront(1);
        boolean empty = list.isEmpty();

        assertFalse(empty);
    }


    @Test
    void sizeEmpty() {
        int size = list.size();

        assertEquals(0, size);
    }

    @Test
    void sizeNotEmpty() {
        populateListWithDummy();

        int size = list.size();

        assertEquals(3, size);
    }

    @Test
    void addToFront() throws EmptyListException {
        populateListWithDummy();

        int integer = list.removeFirst();

        assertEquals(3, integer);
    }


    @Test
    void removeFirstOneItem() throws EmptyListException {
        list.addToFront(1);

        int integer = list.removeFirst();

        assertEquals(1, integer);
    }

    @Test
    void removeFirstThreeItems() throws EmptyListException {
        populateListWithDummy();

        int integer = list.removeFirst();

        assertEquals(3, integer);
    }

    private void populateListWithDummy() {
        list.addToFront(1);
        list.addToFront(2);
        list.addToFront(3);
    }
}