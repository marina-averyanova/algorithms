package com.maveryanova.algorithms.datastructure;

public class SingleArray<T> implements IArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public SingleArray() {
        array = (T[]) new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        increase();
        array[size() - 1] = item;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size()) {
            return array[index];
        } else {
            return null;
        }
    }

    @Override
    public T remove(int index) {
        if (index >= 0 && index < size()) {
            T item = array[index];
            decrease(index);
            return item;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        T[] newArray = (T[]) new Object[size() + 1];

        if (size() >= 0) {
            System.arraycopy(array, 0, newArray, 0, size());
        }
        array = newArray;
    }

    @SuppressWarnings("unchecked")
    private void decrease(int index) {
        T[] newArray = (T[]) new Object[size() - 1];

        if (size() >= 0) {
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, (size() - index) - 1 );
        }
        array = newArray;
    }
}
