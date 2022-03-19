public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addToFront(T data) {
        Node<T> tNode = new Node<T>(data);
        tNode.setNext(head);
        head = tNode;
        size++;
    }

    @Override
    public T removeFirst() throws EmptyListException {
        if (head == null)
            throw new EmptyListException();

        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }
}
