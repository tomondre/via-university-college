package S02_lists_queues_stacks;

public interface StackADT<E> {
    boolean isEmpty();
    E peek();
    E pop();
    E push(E item);
}
