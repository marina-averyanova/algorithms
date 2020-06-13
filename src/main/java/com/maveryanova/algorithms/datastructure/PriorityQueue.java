package com.maveryanova.algorithms.datastructure;

public class PriorityQueue<T> {

    private final PriorityList<T> priorityList;

    public PriorityQueue() {
        priorityList = new PriorityList<>();
    }

    public boolean isEmpty() {
        return priorityList.isEmpty();
    }

    public void enqueue(T item, int priority) throws Exception {
        if (priority < 0) throw new Exception("Priority out of bound");

        DoubleSidedList<T> found = priorityList.find(priority);
        if (found != null) {
            found.addLast(item);
        } else {
            priorityList.add(priority, new DoubleSidedList<>(item));
        }
    }

    public T dequeue() {
        DoubleSidedList<T> innerQueue = priorityList.getFirst();
        T item = innerQueue.deleteFirst();
        if (innerQueue.isEmpty()) {
            priorityList.delete();
        }
        return item;
    }
}
