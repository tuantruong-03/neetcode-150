package com.neetcode.heapnpriorityqueue;

public class KthLargestElementInAnArray {
    // Min-heap
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // min-heap
//        for (int num : nums) {
//            priorityQueue.add(num);
//            if (priorityQueue.size() > k) {
//                priorityQueue.remove();
//            }
//        }
//        return priorityQueue.peek();
//    }

    // Quick select
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, targetIndex);
    }

    private int quickSelect(int[] nums, int left, int right, int targetIndex) {
        // ✅ Base case (REQUIRED)
        if (left == right) {
            return nums[left];
        }

        int pivotValue = nums[right];
        int low = left;
        int high = right - 1;

        while (low <= high) {
            while (low <= high && nums[low] < pivotValue) {
                low++;
            }
            while (low <= high && nums[high] > pivotValue) {
                high--;
            }
            if (low <= high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }

        swap(nums, low, right);
        int pivotIndex = low;

        if (targetIndex == pivotIndex) {
            return nums[pivotIndex];
        } else if (targetIndex < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, targetIndex);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, targetIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
