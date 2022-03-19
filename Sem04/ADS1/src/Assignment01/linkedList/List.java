package Assignment01.linkedList;

import Assignment01.exceptions.EmptyListException;

public interface List<T> {
    boolean isEmpty();
    int size();
    void addToFront(T data);
    T removeFirst() throws EmptyListException;
}
