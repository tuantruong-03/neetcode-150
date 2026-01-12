package com.neetcode.heapnpriorityqueue;

import java.util.*;

//class KthLargest {
//    private final List<Integer> list;
//    private final int k;
//    public KthLargest(int k, int[] nums) {
//        this.list = new ArrayList<>();
//        this.k = k;
//        for (int num : nums) {
//            add(num);
//        }
//    }
//
//    public int add(int val) {
//        if (list.size() < k) {
//            list.add(val);
//            int min = list.size() - 1;
//            int parent = (min - 1)/ 2;
//            while(min > 0 && list.get(parent) >  list.get(min)) { // min heapify up
//                Collections.swap(list, min, parent);
//                min = parent;
//                parent = (min - 1)/2;
//            }
//            return list.getFirst();
//        }
//        if (val <= list.getFirst()) {
//            return list.getFirst();
//        }
//        // Case: val > list.getFirst()
//        list.add(val);
//        pop();
//        return  list.getFirst();
//    }
//
//    public int pop() {
//        int min = list.getFirst();
//        Collections.swap(list, 0, list.size() -1);
//        list.removeLast();
//        minHeapifyDown(0, list.size());
//        return min;
//    }
//
//    private void minHeapifyDown(int i, int size) {
//        int smallest = i;
//        int left = 2*i + 1;
//        int right = 2*i + 2;
//        if (left < size && list.get(left) < list.get(smallest)) {
//            smallest = left;
//        }
//        if (right < size && list.get(right) < list.get(smallest)) {
//            smallest = right;
//        }
//        if (smallest != i) { // smallest is the left or right child
//            Collections.swap(list, i, smallest);
//            minHeapifyDown(smallest, size);
//        }
//    }
//}

class KthLargest {
    private final PriorityQueue<Integer> pq;
    private final int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

}

public class KthLargestElementInAStream {
    public static void main(String[] args) {
        var kl = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kl.add(3));
        System.out.println(kl.add(5));
        System.out.println(kl.add(10));


        var end = 3;
    }
}