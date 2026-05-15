package com.neetcode.heapnpriorityqueue;

import java.util.PriorityQueue;

public class LastStoneWeight {
    private PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a); // config to max heap
    public int lastStoneWeight(int[] stones) {
        for (int stone : stones) {
            pq.add(stone);
        }
        while (!pq.isEmpty()) {
            int heaviest = pq.poll();
            if (pq.isEmpty()) return heaviest;
            int secondHeaviest = pq.poll();
            int newStone = heaviest - secondHeaviest;
            if (newStone != 0) pq.add(newStone);
        }
        return 0;
    }
}

class LastStoneWeightPractice {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max heap
        for (int stone : stones) {
            pq.add(stone);
        }
        while (!pq.isEmpty()) {
            int heaviest = pq.poll();
            if (pq.isEmpty()) return heaviest;
            int secondHeaviest = pq.poll();
            int newStone = heaviest - secondHeaviest;
            if (newStone != 0) {
                pq.add(newStone);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}