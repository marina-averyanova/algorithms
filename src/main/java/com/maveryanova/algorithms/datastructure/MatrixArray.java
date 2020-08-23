package com.maveryanova.algorithms.datastructure;

public class MatrixArray<T> implements IArray<T> {

    private IArray<FactorArray<T>> array;
    private int vector;
    private int size;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new FactorArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (shouldExpand()) {
            array.add(new FactorArray<>(vector));
        }
        array.get(outerArraySize()).add(item);
        size ++;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return array.get(outerIndex(index)).get(innerIndex(index));
        } else {
            return null;
        }
    }

    @Override
    public T remove(int index) {
        T item = get(index);

        if (item != null) {
            decrease(index);
            size--;
            return item;
        } else {
            return null;
        }
    }

    private int outerArraySize() {
        return vector == 0 ? vector : size / vector;
    }

    private int outerIndex(int index) {
        return vector == 0 ? vector : index / vector;
    }

    private int innerIndex(int index) {
        return vector == 0 ? vector : index % vector;
    }

    private boolean shouldExpand() {
        return size == array.size() * vector;
    }

    private void decrease(int index) {
        IArray<FactorArray<T>> newArray = new FactorArray<>();

        for (int i = 0; i <= outerArraySize(); i++) {
            if (i < outerIndex(index)) {
                newArray.add(array.get(i));
            } else if (i == outerIndex(index)) {
                FactorArray<T> innerArray = array.get(i);
                innerArray.remove(innerIndex(index));
                addFirstToTail(i, innerArray);
                newArray.add(innerArray);
            } else {
                FactorArray<T> innerArray = array.get(i);
                if (innerArray != null) { // NOTE size not decreased yet, should check
                    innerArray.remove(0);
                    addFirstToTail(i, innerArray);
                }

                newArray.add(innerArray);
            }
        }
        array = newArray;
    }

    private void addFirstToTail(int index, FactorArray<T> arr) {
        FactorArray<T> nextArr = array.get(index + 1);
        if (nextArr != null) {
            arr.add(nextArr.get(0));
        }
    }
}
