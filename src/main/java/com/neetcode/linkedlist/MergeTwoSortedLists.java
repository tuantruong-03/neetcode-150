package com.neetcode.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prevHead = new ListNode();
        ListNode tempPrevHead = prevHead;
        while (list1 != null && list2 != null) {
            int list2Val = list2.val;
            int list1Val = list1.val;
            if (list2Val <= list1Val) {
                tempPrevHead.next = new ListNode(list2Val);
                list2 = list2.next;
            } else {
                tempPrevHead.next = new ListNode(list1Val);
                list1 = list1.next;
            }
            tempPrevHead = tempPrevHead.next;
        }
        while (list1 != null) {
            tempPrevHead.next = new ListNode(list1.val);
            tempPrevHead = tempPrevHead.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            tempPrevHead.next = new ListNode(list2.val);
            tempPrevHead = tempPrevHead.next;
            list2 = list2.next;
        }
        return prevHead.next;
    }
}
