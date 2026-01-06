package com.neetcode.heapnpriorityqueue;

/*
* 1️⃣ Heap (Data Structure)

A Heap is a specialized tree-based data structure that satisfies two rules:

✅ Properties of a Heap
1. Complete Binary Tree
- All levels are completely filled except possibly the last.
- Nodes are filled from left to right.
2. Heap Property
- Max Heap: Parent ≥ children
- Min Heap: Parent ≤ children
🔹 Types of Heap
Type	    Rule
Max Heap	Largest element at the root
Min Heap	Smallest element at the root
🔹 Example (Min Heap)
        1
       / \
      3   5
     / \
    7   9

🔹 Common Operations
Operation   	Time
Insert	        O(log n)
Delete (root)	O(log n)
Peek (min/max)	O(1)

👉 Heaps are usually implemented using arrays, not pointers.
Some notes:
- Non-leaf node index: n/2 -1
*
* */



class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    private int leftIndex(int i) {
        return 2 * i + 1;
    }

    private int rightIndex(int i) {
        return 2*i + 2;
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new RuntimeException("full heap");
        }
        int curr = size;
        heap[curr] = value;
        size++;
        while (curr > 0 && heap[curr] < heap[parentIndex(curr)]) {
            swap(curr, parentIndex(curr)); // Move curr up until heap[curr] >= heap[parentIndex(curr)] or curr is root
            curr = parentIndex(curr);
        }
    }

    public int min() {
        if (size == 0)
            throw new RuntimeException("Heap is empty");
        int min = heap[0];
        heap[0] = heap[size -1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int i) {
        int smallest = i;
        int left = leftIndex(i);
        int right = rightIndex(i);
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    public int peek() {
        if (size == 0)
            throw new RuntimeException("Heap is empty");
        return heap[0];
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

