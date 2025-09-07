package com.neetcode.linkedlist;

import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {
    public ListNode reverseList1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        head = new ListNode(stack.pop());
        ListNode tempHead = head;
        while (!stack.isEmpty()) {
            tempHead.next = new ListNode(stack.pop());
            tempHead = tempHead.next;
        }
        return head;
    }
    public ListNode reverseList2(ListNode head) {
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