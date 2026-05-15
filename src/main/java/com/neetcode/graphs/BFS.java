package com.neetcode.graphs;

import com.neetcode.linkedlist.ListNode;

import java.util.*;

public class BFS {
    // Use Queue or List
    // In BFS, if a vertex is in the queue, it should already be marked as visited.
    public static List<Character> visit(Map<Character, List<Character>> adjacentList, Character vertex) {
        List<Character> result = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        visited.add(vertex);
        queue.add(vertex);
        result.add(vertex);
        while (!queue.isEmpty()) {
            char visit = queue.poll();
            List<Character> neighbors = adjacentList.getOrDefault(visit, new ArrayList<>());
            for (Character neighbor : neighbors) {
                if (visited.contains(neighbor)) continue;
                visited.add(neighbor);
                queue.add(neighbor);
                result.add(neighbor);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Character> visits = BFS.visit(Graph.adjacentList(), 'A');
        System.out.println(visits.toString());
    }
}

class BFSPractice {
    // Queue
    public static List<Character> visit(Map<Character, List<Character>> adjacentList, Character vertex) {
        List<Character> result = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        result.add(vertex);
        visited.add(vertex);
        queue.add(vertex);
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            for (Character neighbor : adjacentList.getOrDefault(c, new ArrayList<>())) {
                if (visited.contains(neighbor)) continue;
                result.add(neighbor);
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Character> visits = BFS.visit(Graph.adjacentList(), 'A');
        System.out.println(visits.toString());
    }
}