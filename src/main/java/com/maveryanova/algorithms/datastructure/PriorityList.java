package com.maveryanova.algorithms.datastructure;

public class PriorityList<T> {

    private PriorityListNode<T> first;

    PriorityList() {
        first = null;
    }

    boolean isEmpty() {
        return first == null;
    }

    void add(int priority, DoubleSidedList<T> innerQueue) {
       PriorityListNode<T> newQueueNode = new PriorityListNode<T>(priority, innerQueue);
       PriorityListNode<T> previous = null;
       PriorityListNode<T> current = first;

       while (current != null && priority > current.getPriority()) {
           previous = current;
           current = current.getNext();
       }

       if (previous == null) {
           first = newQueueNode;
       } else {
           previous.setNext(newQueueNode);
       }

        newQueueNode.setNext(current);
    }

    DoubleSidedList<T> delete() {
        PriorityListNode<T> temp = first;
        first = first.getNext();
        return temp.getInnerQueue();
    }

    DoubleSidedList<T> getFirst() {
        return first.getInnerQueue();
    }

    DoubleSidedList<T> find(int priority) {
        if (isEmpty()) {
            return null;
        }
        PriorityListNode<T> current = first;
        while (current.getPriority() != priority) {
            if (current.getNext() == null) {
                return null;
            } else {
                current = current.getNext();
            }
        }
        return current.getInnerQueue();
    }
}
