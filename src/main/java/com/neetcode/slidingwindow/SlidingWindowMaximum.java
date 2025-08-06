package com.neetcode.slidingwindow;

import java.util.*;

public class SlidingWindowMaximum {
    // Solution 1
    public int[] maxSlidingWindowS1(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int previousMaxIndex = 0;
        for (int i = 0; i < k && i < n; ++i) {
            if (nums[i] >= nums[previousMaxIndex]) {
                previousMaxIndex = i;
            }
        }
        res.add(nums[previousMaxIndex]);
        if (n <= k) return res.stream().mapToInt(i -> i).toArray();
        int l = 1;
        int r = k;
        while (r < n) {
            if (previousMaxIndex >= l) {
                if (nums[r] >= nums[previousMaxIndex])  {
                    previousMaxIndex = r;
                }
            } else {
                previousMaxIndex = maxIndexInWindow(nums, l, r);
            }
            res.add(nums[previousMaxIndex]);
            r++;
            l++;
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    private int maxIndexInWindow(int []nums, int l, int r) {
        int maxIndex = l;
        for (int i = l; i <= r; ++i) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (!deque.isEmpty() && deque.peekFirst() <= i -k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // At this step, it's ensure that the numbers at the head indexes of queue are greater than the number at i index
            deque.offerLast(i);
            if (i >= k -1) {
                res.add(nums[deque.peekFirst()]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }


}
