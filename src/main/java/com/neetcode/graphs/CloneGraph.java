package com.neetcode.graphs;

import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        // Create the clone of the starting node
        Node result = new Node(node.val);
        // Use BFS
        Queue<Node> queue = new LinkedList<>();
        // Map original node -> cloned node
        // Also acts as a visited set
        Map<Node, Node> oldToNew = new HashMap<>();
        queue.add(node);
        oldToNew.put(node, result);

        // BFS traversal
        while (!queue.isEmpty()) {
            Node old = queue.poll();
            Node _new = oldToNew.get(old);

            for (Node neighbor : old.neighbors) {
                Node neighborClone = oldToNew.get(neighbor);
                if (neighborClone != null && _new.neighbors.contains(neighborClone))
                    continue;
                // If neighbor was never visited before
                if (neighborClone == null) {
                    // Create clone node
                    neighborClone = new Node(neighbor.val);
                    // Add original neighbor to queue for BFS traversal
                    queue.add(neighbor);
                }
                _new.neighbors.add(neighborClone);
                oldToNew.put(neighbor, neighborClone);
            }
        }

        // Return cloned graph entry
        return result;
    }
}
