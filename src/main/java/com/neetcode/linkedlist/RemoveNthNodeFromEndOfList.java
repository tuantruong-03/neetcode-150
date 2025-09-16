package com.neetcode.linkedlist;

public class RemoveNthNodeFromEndOfList {
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
