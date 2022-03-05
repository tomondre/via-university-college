package assignment_01.linkedList;

import assignment_01.exceptions.EmptyListException;

public interface List<T> {
    boolean isEmpty();
    int size();
    void addToFront(T data);
    T removeFirst() throws EmptyListException;
}
