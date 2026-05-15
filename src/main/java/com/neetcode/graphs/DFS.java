package com.neetcode.graphs;

import java.util.*;

public class DFS {
    // Stack
    public static List<Character> visit(Map<Character, List<Character>> adjacentList, Character vertex) {
        List<Character> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new HashSet<>();
        stack.push(vertex);
        while (!stack.isEmpty()) {
            char visit = stack.pop();
            if (visited.contains(visit)) continue;
            visited.add(visit);
            result.add(visit);
            List<Character> neighbors = adjacentList.getOrDefault(visit, new ArrayList<>());
            for (Character neighbor : neighbors) {
                if (visited.contains(neighbor)) continue;
                stack.push(neighbor);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Character> visits = DFS.visit(Graph.adjacentList(), 'A');
        System.out.println(visits.toString());
    }

}

class DFSPractice {
    public static List<Character> visit(Map<Character, List<Character>> adjacentList, Character vertex) {
        List<Character> result = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        stack.add(vertex);
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            result.add(c);
            visited.add(c);
            for (Character neighbor : adjacentList.getOrDefault(c, new ArrayList<>())) {
                if (visited.contains(neighbor)) continue;
                stack.push(neighbor);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Character> visits = DFS.visit(Graph.adjacentList(), 'A');
        System.out.println(visits.toString());
    }
}
