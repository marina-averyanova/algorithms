package com.maveryanova.algorithms.datastructure;

public class PriorityListNode<T> {

    private final int priority;
    private final DoubleSidedList<T> innerQueue;
    private PriorityListNode<T> next;

    PriorityListNode(int priority, DoubleSidedList<T> innerQueue, PriorityListNode<T> next) {
        this.priority = priority;
        this.innerQueue = innerQueue;
        this.next = next;
    }

    PriorityListNode(int priority, DoubleSidedList<T> innerQueue) {
        this(priority, innerQueue, null);
    }

    DoubleSidedList<T> getInnerQueue() {
        return innerQueue;
    }

    int getPriority() {
        return priority;
    }

    PriorityListNode<T> getNext() {
        return next;
    }

    void setNext(PriorityListNode<T> next) {
        this.next = next;
    }
}
