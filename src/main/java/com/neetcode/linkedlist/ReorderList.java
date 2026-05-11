package com.neetcode.linkedlist;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        int n = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            n++;
            tempHead = tempHead.next;
        }
        tempHead = head;
        Stack<ListNode> stack = new Stack<>();
        while (tempHead != null) {
            stack.add(tempHead);
            tempHead = tempHead.next;
        }

        tempHead = head;
        for (int i = 0; i < n/2 && tempHead != null; ++i) {
            ListNode next = tempHead.next;
            ListNode last = stack.pop();
            tempHead.next = last;
            last.next = next;
            tempHead = next;
        }
        if (tempHead != null) {
            tempHead.next = null;
        }
    }

    public void reorderList2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHalfEndHead = reverseList(slow.next);
        slow.next = null;
        ListNode tempHead = head;
        while (reverseHalfEndHead != null) {
            ListNode tmp1 = tempHead.next;
            ListNode tmp2 = reverseHalfEndHead.next;

           tempHead.next = reverseHalfEndHead;
           reverseHalfEndHead.next = tmp1;

           tempHead = tmp1;
           reverseHalfEndHead = tmp2;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class ReorderListPractice {
    // Reorder linked list from:
    // 1 -> 2 -> 3 -> 4 -> 5
    //
    // Into:
    // 1 -> 5 -> 2 -> 4 -> 3
    //
    // High-level idea:
    // 1. Find the middle of the list
    // 2. Reverse the second half
    // 3. Merge the two halves alternately
    //
    // Example:
    // Original:
    // 1 -> 2 -> 3 -> 4 -> 5
    //
    // Step 1: Find middle
    // First half : 1 -> 2 -> 3
    // Second half: 4 -> 5
    //
    // Step 2: Reverse second half
    // 5 -> 4
    //
    // Step 3: Merge alternately
    // 1 -> 5 -> 2 -> 4 -> 3
    // (Draw the linked list for the better comprehension of this solution)
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        assert slow != null;
        ListNode reverseHalfEndHead = reverseList(slow.next);
        slow.next = null;
        ListNode tmp = head;
        while (reverseHalfEndHead != null) {
            ListNode tmp1 = tmp.next;
            ListNode tmp2 = reverseHalfEndHead.next;

            tmp.next = reverseHalfEndHead;
            reverseHalfEndHead.next = tmp1;

            tmp = tmp1;
            reverseHalfEndHead = tmp2;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}