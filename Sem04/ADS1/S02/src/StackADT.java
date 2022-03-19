public interface StackADT<T> {
    boolean isEmpty();
    T peek();
    T pop();
    T push(T item);
}
