package com.maveryanova.algorithms.datastructure;

public class DoubleSidedList<T> {

    private Node<T> first;
    private Node<T> last;

    DoubleSidedList() {
        first = null;
        last = null;
    }

    DoubleSidedList(T item) {
        this();
        addLast(item);
    }

    boolean isEmpty() {
        return first == null;
    }

    void addLast(T item) {
       Node<T> newNode = new Node<>(item);
       if (isEmpty()) {
           first = newNode;
       } else {
           last.setNext(newNode);
       }
       last = newNode;
    }

    T deleteFirst() {
        Node<T> temp = first;
        if (first.getNext() == null) {
            last = null;
        }
        first = first.getNext();
        return temp.getItem();
    }
}
