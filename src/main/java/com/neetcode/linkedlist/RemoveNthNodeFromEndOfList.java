package com.neetcode.linkedlist;

public class RemoveNthNodeFromEndOfList {
    /*
     * Idea:
     * Instead of directly finding the Nth node from the end,
     * we first count the total number of nodes in the linked list.
     *
     * Once we know the total size:
     *
     *     indexFromStart = totalNodes - n
     *
     * This converts the problem into:
     * "Remove the node at indexFromStart from the beginning."
     *
     * Example:
     * List: 1 -> 2 -> 3 -> 4 -> 5
     * n = 2
     *
     * Total nodes = 5
     * indexFromStart = 5 - 2 = 3
     *
     * So we remove the node at index 3 (0-based),
     * which is value 4.
     *
     * Steps:
     * 1. Traverse the list once to count total nodes.
     * 2. Handle edge case:
     *      - If totalNodes == n,
     *        it means we must remove the head node.
     * 3. Traverse again until reaching the target index.
     * 4. Keep track of the previous node so we can bypass
     *    the target node:
     *
     *        prev.next = current.next
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            count++;
            tempHead = tempHead.next;
        }
        if (count == n) return head == null ? null : head.next;
        int deleteIndex = count - n;
        int i = 0;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            if (i == deleteIndex) {
                prev.next = current.next;
                return head;
            }
            prev = current;
            current = current.next;
            i++;
        }
        return head;
    }
}
