package com.neetcode.graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public static Map<Character, List<Character>> adjacentList() {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', List.of('B', 'C'));
        graph.put('B', List.of('A', 'D', 'E'));
        graph.put('C', List.of('A', 'F'));
        graph.put('D', List.of('B', 'G', 'H'));
        graph.put('E', List.of('B', 'F', 'I'));
        graph.put('F', List.of('C', 'E', 'I'));
        graph.put('G', List.of('D'));
        graph.put('H', List.of('D', 'I'));
        graph.put('I', List.of('E', 'F', 'H', 'J'));
        graph.put('J', List.of('I'));
        return graph;
    }
}

/*
        A
       / \
      B   C
     / \   \
    D   E   F
   / \  |   |
  G   H |   |
       \|  /
        I
        |
        J
* */