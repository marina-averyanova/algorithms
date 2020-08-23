package com.maveryanova.algorithms.sorting;

public class HeapSort extends Sort {

    @Override
    public int[] sort() {
        int[] array = copyArray();

        findMax(0, array, array.length); // max element goes to first

        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            findMax(0, array, i);
        }

        return array;
    }

    private void findMax(int root, int[] array, int partitionPoint) {
        // max element goes to root
        for (int i = root + 1; i < partitionPoint; i++) {
            if (array[root] < array[i]) {
                swap(array, root, i);
            }
        }
    }
}
