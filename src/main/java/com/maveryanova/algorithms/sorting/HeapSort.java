package com.maveryanova.algorithms.sorting;

public class HeapSort extends Sort {

    @Override
    public int[] sort() {
        int[] array = copyArray();

        // build start heap
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
        }

        return array;
    }

    private void heapify(int[] array, int rootIndex, int heapSize) {
        // max element goes to root
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = leftChildIndex + 1;

        int tempIndex = rootIndex;
        if (leftChildIndex < heapSize && array[tempIndex] < array[leftChildIndex])
            tempIndex = leftChildIndex;
        if (rightChildIndex < heapSize && array[tempIndex] < array[rightChildIndex])
            tempIndex = rightChildIndex;

        if (rootIndex == tempIndex)
            return;

        swap(array, tempIndex, rootIndex);

        heapify(array, tempIndex, heapSize);
    }
}
