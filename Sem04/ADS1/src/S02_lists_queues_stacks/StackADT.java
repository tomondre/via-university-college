package S02_lists_queues_stacks;

public interface StackADT<T> {
    boolean isEmpty();
    T peek();
    T pop();
    T push(T item);
}
