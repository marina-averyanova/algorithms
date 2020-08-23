package com.maveryanova.algorithms.datastructure;

import java.util.ArrayList;

public class JavaListArray<T> implements IArray<T> {

    private ArrayList<T> array;

    public JavaListArray() {
        array = new ArrayList<T>();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public void add(T item) {
        array.add(item);
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size()) {
            return array.get(index);
        } else {
            return null;
        }
    }

    @Override
    public T remove(int index) {
        if (index >= 0 && index < size()) {
            return array.remove(index);
        } else {
            return null;
        }
    }
}
