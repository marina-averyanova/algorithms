package com.maveryanova.algorithms.datastructure;

public interface IArray<T> {

    int size();

    void add(T item);

    T get(int index);

    T remove(int index);
}
