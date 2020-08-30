package com.maveryanova.algorithms.sorting;

public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] arrayToSort) {
        int[] array = SortUtils.copyArray(arrayToSort);

        int outerCounter;
        int innerCounter;
        int indexMin;

        for (outerCounter = 0; outerCounter < array.length - 1; outerCounter++) {
            indexMin = outerCounter;
            for (innerCounter = outerCounter + 1; innerCounter < array.length; innerCounter++) {
                if (array[innerCounter] < array[indexMin]) {
                    indexMin = innerCounter;
                }
            }
            SortUtils.swap(array, outerCounter, indexMin);
        }
        return array;
    }
}
