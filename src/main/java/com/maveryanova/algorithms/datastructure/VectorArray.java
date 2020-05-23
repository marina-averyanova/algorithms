package com.maveryanova.algorithms.datastructure;

@SuppressWarnings("unchecked")
public class VectorArray<T> implements IArray<T> {

    private T[] array;
    private int vector;
    private int size;

    public VectorArray(int vector) {
        this.vector = vector;
        array = (T[]) new Object[0];
        size = 0;
    }

    public VectorArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length) {
            increase();
        }
        array[size] = item;
        size++;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
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
        T[] newArray = (T[]) new Object[array.length + vector];
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
