package com.maveryanova.algorithms.sorting;

import java.util.Arrays;

public class SortUtils {
    public static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public static int[] copyArray(int[] arrayToSort) {
        // we don't want to mutate given data
        return Arrays.copyOf(arrayToSort, arrayToSort.length);
    }
}
