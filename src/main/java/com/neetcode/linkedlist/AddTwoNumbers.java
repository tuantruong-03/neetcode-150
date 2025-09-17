package com.neetcode.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode();
        ListNode tempPrevHead = prevHead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int digit = sum % 10;
            carry = sum >= 10 ? 1 : 0;
            tempPrevHead.next = new ListNode(digit);
            l1 = l1.next;
            l2 = l2.next;
            tempPrevHead = tempPrevHead.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            int digit = sum % 10;
            carry = sum >= 10 ? 1 : 0;
            tempPrevHead.next = new ListNode(digit);
            l1 = l1.next;
            tempPrevHead = tempPrevHead.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            int digit = sum % 10;
            carry = sum >= 10 ? 1 : 0;
            tempPrevHead.next = new ListNode(digit);
            l2 = l2.next;
            tempPrevHead = tempPrevHead.next;
        }
        if (carry == 1) {
            tempPrevHead.next = new ListNode(carry);
        }
        return prevHead.next;
    }
}
