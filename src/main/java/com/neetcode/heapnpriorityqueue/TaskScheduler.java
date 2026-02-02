package com.neetcode.heapnpriorityqueue;
import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>((a, b) -> b.frequency - a.frequency); // max-heap
        Map<Character, Integer> frequency = new HashMap<>();
        for (var task : tasks) {
            int freq = frequency.getOrDefault(task,0);
            frequency.put(task, freq + 1);
        }
        for (var entry : frequency.entrySet()) {
            Task task = new Task(entry.getKey(), entry.getValue());
            taskPriorityQueue.add(task);
        }
        frequency.clear();
        int interval = 0;
        while (!taskPriorityQueue.isEmpty()) {
            Task task = taskPriorityQueue.remove();
            //  Allow the completion of one task.
            if (task.lastCompleted == null || interval - task.lastCompleted > n) {
                task.frequency -= 1;
                task.lastCompleted = interval;
                if (task.frequency != 0) {
                    taskPriorityQueue.add(task);
                }
                interval++;
                continue;
            }
            PriorityQueue<Task> temp = new PriorityQueue<>((a,b) -> b.frequency - a.frequency);
            temp.add(task);
            while (!taskPriorityQueue.isEmpty()) {
                task = taskPriorityQueue.remove();
                if (task.lastCompleted == null || interval - task.lastCompleted > n) {
                    task.frequency -= 1;
                    task.lastCompleted = interval;
                    if (task.frequency != 0) {
                        taskPriorityQueue.add(task);
                    }
                    break;
                }
                temp.add(task);
            }
            while (!temp.isEmpty()) {
                taskPriorityQueue.add(temp.remove());
            }
            interval++;
        }
        return interval;
    }

    private static class Task {
        Character label;
        int frequency;
        Integer lastCompleted;

        public Task(Character label, int frequency) {
            this.label = label;
            this.frequency = frequency;
        }
    }
}
// (maxFreq - 1) * (n + 1) + maxCount

/* ["B","C","D","A","A","A","A","G"]
* [A,B,A,C,A,D,A,G]
* */