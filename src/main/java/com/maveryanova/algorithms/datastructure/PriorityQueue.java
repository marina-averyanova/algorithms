package com.maveryanova.algorithms.datastructure;

import java.lang.reflect.Array;

public class PriorityQueue<T> {

    private DoubleSidedList<T>[] rows;
    private int rowsSize;

    public PriorityQueue() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue(int size) {
        rowsSize = size;
        rows = (DoubleSidedList<T>[]) Array.newInstance(DoubleSidedList.class, size);
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        int i = 0;
        while (i < rows.length && isEmpty) {
            DoubleSidedList<T> priorityRow = rows[i];
            if (priorityRow != null) {
                isEmpty = priorityRow.isEmpty();
            }
            i++;
        }
        return isEmpty;
    }

    public void enqueue(T item, int priority) throws Exception {
        if (priority < 0) throw new Exception("Priority out of bound");

        if (priority > rowsSize) {
            increaseRows(priority);
            rows[priority] = (new DoubleSidedList<>(item));
        } else {
            DoubleSidedList<T> priorityRow = rows[priority];
            if (priorityRow != null) {
                priorityRow.addLast(item);
            } else {
                rows[priority] = (new DoubleSidedList<>(item));
            }
        }
    }

    public T dequeue() {
        int i = 0;
        T item = null;
        while (i < rows.length && item == null) {
            DoubleSidedList<T> priorityRow = rows[i];
            if (priorityRow != null && !priorityRow.isEmpty()) {
                item = priorityRow.deleteFirst();
            }
            i++;
        }
        return item;
    }

    @SuppressWarnings("unchecked")
    private void increaseRows(int maxIndex) {
        DoubleSidedList<T>[] newRows = (DoubleSidedList<T>[]) Array.newInstance(DoubleSidedList.class, maxIndex + 1);
        System.arraycopy(rows, 0, newRows, 0, rows.length - 1);
        rows = newRows;
        rowsSize = rows.length;
    }
}
