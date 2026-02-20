package com.neetcode.linkedlist;


import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode prevHead = new ListNode();
        ListNode temp = prevHead;
        PriorityQueue<WrapperNode> listNodePQ = new PriorityQueue<>((a, b) -> a.node.val - b.node.val);
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] == null) continue;
            listNodePQ.add(new WrapperNode(lists[i], i));
        }
        while (!listNodePQ.isEmpty()) {
            WrapperNode minNode = listNodePQ.remove();
            temp.next = minNode.node;
            temp = temp.next;
            ListNode nextOfMinNode = minNode.node.next;
            lists[minNode.listIndex] = nextOfMinNode;
            if (nextOfMinNode != null) {
                listNodePQ.add(new WrapperNode(nextOfMinNode, minNode.listIndex));
            }
        }
        return prevHead.next;
    }

    private static class WrapperNode {
        ListNode node;
        int listIndex;

        WrapperNode(ListNode node, int listIndex) {
            this.node = node;
            this.listIndex = listIndex;
        }
    }

//    public static void main(String[] args) {
//        MergeKSortedLists solution = new MergeKSortedLists();
//
//        // Build list 1: 1 -> 4 -> 5
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(5);
//
//        // Build list 2: 1 -> 3 -> 4
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
//
//        // Build list 3: 2 -> 6
//        ListNode l3 = new ListNode(2);
//        l3.next = new ListNode(6);
//
//        ListNode[] lists = new ListNode[]{l1, l2, l3};
//
//        ListNode result = solution.mergeKLists(lists);
//
//    }
}
