import java.util.EmptyStackException;

public interface Stack<T> {
    boolean isEmpty();
    void push(T elm);
    T pop() throws EmptyStackException;
}
