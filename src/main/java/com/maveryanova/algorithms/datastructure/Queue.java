package com.maveryanova.algorithms.datastructure;

public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<T>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode); // add next to current tail
            tail = newNode;        // change tail
        }
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T item = head.getItem();
        head = head.getNext();     // change head to previous
        return item;
    }
}
