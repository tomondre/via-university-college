package assignment_01;

import assignment_01.excpetions.EmptyListException;

public interface List<T> {
    boolean isEmpty();
    int size();
    void addToFront(T data);
    T removeFirst() throws EmptyListException;
}
