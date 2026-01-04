package com.neetcode.linkedlist;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SwapNodesInPairs {
//    public ListNode swapPairs(ListNode head) {
//        Map<Integer, ListNode> map = new HashMap<>();
//        ListNode temp = head;
//        int count = 0;
//        while (temp != null) {
//            map.put(count++, temp);
//            temp = temp.next;
//        }
//        for (int i = 0; i < count; i += 2) {
//            ListNode _prev = map.get(i - 1);
//            ListNode _curr = map.get(i);
//            ListNode _next = map.get(i + 1);
//            if (_next == null) {
//                if (_prev != null) {
//                    _prev.next = _curr;
//                }
//                break;
//            }
//            _next.next = _curr;
//            _curr.next = null;
//            map.put(i, _next);
//            map.put(i + 1, _curr);
//            if (_prev != null) {
//                _prev.next = _next;
//            }
//        }
//        return map.get(0);
//    }

    // Optimized solution
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        while(true) {
            ListNode next1 = curr.next;
            if (next1 == null || next1.next == null) break;
            ListNode next2 = next1.next;
            next1.next = next2.next;
            next2.next = next1;
            curr.next = next2;
            curr = next1;
        }
        return dummy.next;
    }
}
