package com.neetcode.heapnpriorityqueue;

import java.util.PriorityQueue;

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


class KthLargestElementInAnArrayPracticeWithHeap {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}

class KthLargestElementInAnArrayPracticeWithQuickSelect {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private int quickSelect(int []nums, int l, int r, int k) {
        // ✅ Base case (REQUIRED)
        if (l == r) {
            return nums[l];
        }
        int low = l;
        int high = r;
        int pivot = r;
        int pivolVal = nums[pivot];
        while (low <= high) {
            while (low <= high && nums[low] < pivolVal) {
                low++;
            }
            while (low <= high && nums[high] > pivolVal) {
                high--;
            }
            if (low <= high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }
        swap(nums, low, pivot);
        pivot = low;
        if (k == pivot) return nums[pivot];
        if (k > pivot) {
            return quickSelect(nums, pivot + 1, r, k);
        } else {
            return quickSelect(nums, l, pivot - 1, k);
        }
    }

    private void swap(int []nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}

