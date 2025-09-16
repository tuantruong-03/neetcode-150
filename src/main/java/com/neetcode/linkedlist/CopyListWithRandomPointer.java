package com.neetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // Map to store mapping from old nodes to their corresponding new (cloned) nodes
        Map<Node, Node> oldNew = new HashMap<>();

        // Dummy head to simplify list construction
        Node resultHead = new Node(-1);
        Node prevResultHead = resultHead;

        // Traverse the original list
        while (head != null) {
            // --- Handle current node ---
            if (oldNew.containsKey(head)) {
                // If this node was already cloned before (as "next" or "random"), reuse it
                Node existingNew = oldNew.get(head);
                prevResultHead.next = existingNew;
            } else {
                // Otherwise, create a new clone node
                Node newNode = new Node(head.val);
                prevResultHead.next = newNode;
                oldNew.put(head, newNode);
            }

            // Move prevResultHead pointer forward in the cloned list
            prevResultHead = prevResultHead.next;
            // --- Handle next pointer ---
            if (head.next != null) {
                Node next = head.next;
                if (oldNew.containsKey(next)) {
                    // If the "next" node was already cloned, reuse it
                    Node existingNew = oldNew.get(next);
                    prevResultHead.next = existingNew;
                } else {
                    // Otherwise, create and store the clone of "next"
                    Node newNextNode = new Node(next.val);
                    prevResultHead.next = newNextNode;
                    oldNew.put(next, newNextNode);
                }
            }
            // --- Handle random pointer ---
            if (head.random != null) {
                Node random = head.random;
                if (oldNew.containsKey(random)) {
                    // If the "random" node was already cloned, reuse it
                    Node existingRandom = oldNew.get(random);
                    prevResultHead.random = existingRandom;
                } else {
                    // Otherwise, create and store the clone of "random"
                    Node newRandomNode = new Node(random.val);
                    prevResultHead.random = newRandomNode;
                    oldNew.put(random, newRandomNode);
                }
            }

            // Advance head to the next node in original list
            head = head.next;
        }

        // Return head of cloned list (skip dummy)
        return resultHead.next;
    }

}
