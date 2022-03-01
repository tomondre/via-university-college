package S02_lists_queues_stacks;

import java.util.EmptyStackException;
import java.util.List;

public class StackImpl<T> implements StackADT<T> {

    private Node<T> head = null;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T peek() {
        if (head == null) throw new EmptyStackException();

        return head.getData();
    }

    @Override
    public T pop() {
        if (head == null) throw new EmptyStackException();

        T data = head.getData();
        head = head.getNext();
        return data;
    }

    @Override
    public T push(T item) {
        Node<T> tNode = new Node<>(item);
        tNode.setNext(head);
        head = tNode;
        return head.getData();
    }
}
