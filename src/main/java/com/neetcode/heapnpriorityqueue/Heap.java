package com.neetcode.heapnpriorityqueue;

public class Heap {

    public static void sort(int []arr) {
        int n = arr.length;
        int nonLeafNodeIndex = n/2 - 1;
        for (int i = nonLeafNodeIndex; i >= 0; i--) {
            maxHeapifyDown(arr, n, i);
        }
        for (int i = n -1; i >= 0; --i) {
            swap(arr, 0, i); // Swap max and last node
            maxHeapifyDown(arr, i, 0); // i is also the length of array when exclude last node (max)
        }
    }

    private static void maxHeapifyDown(int []arr, int size, int index) {
        int largest = index;
        int left = 2*index + 1;
        int right = 2*index + 2;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(arr, index, largest);
            maxHeapifyDown(arr, size, largest);
        }
    }

    private static void swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
