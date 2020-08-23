package com.maveryanova.algorithms.datastructure;

public class FactorArray<T> implements IArray<T> {

    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public FactorArray(int initLength) {
        array = (T[]) new Object[initLength];
        size = 0;
    }

    public FactorArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            increase();
        array[size] = item;
        size++;
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
        if (index >= 0 && index < size) {
            T item = array[index];
            decrease(index);
            size--;
            return item;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @SuppressWarnings("unchecked")
    private void decrease(int index) {
        T[] newArray = (T[]) new Object[array.length - 1];

        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, (array.length - index) - 1 );

        array = newArray;
    }
}
