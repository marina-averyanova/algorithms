package com.maveryanova.algorithms.sorting;

public class InsertionSort implements Sort {

    @Override
    public int[] sort(int[] arrayToSort) {
        int[] array = SortUtils.copyArray(arrayToSort);

        int innerCounter;
        int outerCounter;
        for (outerCounter = 1; outerCounter < array.length; outerCounter++) {
            int temp = array[outerCounter];
            innerCounter = outerCounter;

            while (innerCounter > 0 && array[innerCounter - 1] >= temp) {
                array[innerCounter] = array[innerCounter - 1];
                --innerCounter;
            }
            array[innerCounter] = temp;
        }
        return array;
    }
}
