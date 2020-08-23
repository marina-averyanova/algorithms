package com.maveryanova.algorithms.sorting;

public class SelectionSort extends Sort {

    @Override
    public int[] sort() {
        int[] array = copyArray();

        int outerCounter, innerCounter, indexMin;
        for (outerCounter = 0; outerCounter < getLength() - 1; outerCounter++) {
            indexMin = outerCounter;
            for (innerCounter = outerCounter + 1; innerCounter < getLength(); innerCounter++) {
                if (array[innerCounter] < array[indexMin]) {
                    indexMin = innerCounter;
                }
            }
            swap(array, outerCounter, indexMin);
        }
        return array;
    }
}
