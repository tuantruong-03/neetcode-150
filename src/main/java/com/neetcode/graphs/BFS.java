package com.neetcode.graphs;

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
