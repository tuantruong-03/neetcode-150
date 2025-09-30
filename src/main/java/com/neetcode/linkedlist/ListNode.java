package com.neetcode.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode previous;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
