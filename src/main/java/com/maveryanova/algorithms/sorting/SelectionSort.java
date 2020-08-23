package com.maveryanova.algorithms.sorting;

public class SelectionSort extends Sort {

    @Override
    public int[] sort() {
        int[] array = copyArray();

        int outerCounter, innerCounter, indexMin;
        for (outerCounter = 0; outerCounter < array.length - 1; outerCounter++) {
            indexMin = outerCounter;
            for (innerCounter = outerCounter + 1; innerCounter < array.length; innerCounter++) {
                if (array[innerCounter] < array[indexMin]) {
                    indexMin = innerCounter;
                }
            }
            swap(array, outerCounter, indexMin);
        }
        return array;
    }
}
