import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    private LinkedStack<Integer> stack;

    @BeforeEach
    void beforeEach() {
        stack = new LinkedStack<Integer>();
    }

    @Test
    void isEmptyTrue() {
        boolean isEmpty = stack.isEmpty();

        assertTrue(isEmpty);
    }

    @Test
    void isEmptyFalse() {
        stack.push(1);
        boolean isEmpty = stack.isEmpty();

        assertFalse(isEmpty);
    }

    @Test
    void pushWithIsEmpty() {
        stack.push(1);
        boolean isEmpty = stack.isEmpty();

        assertFalse(isEmpty);
    }

    @Test
    void pop() {
        stack.push(1);
        int pop = stack.pop();

        assertEquals(1, pop);
    }

    @Test
    void popEmpty() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }
}
