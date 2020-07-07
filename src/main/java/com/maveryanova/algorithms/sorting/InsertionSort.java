package com.maveryanova.algorithms.sorting;

public class InsertionSort extends Sort{

    @Override
    public int[] sort() {
        int[] array = new int[getLength()];
        System.arraycopy(getArray(), 0, array, 0,getLength());

        int innerCounter, outerCounter;
        for (outerCounter = 1; outerCounter < getLength(); outerCounter++) {
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
