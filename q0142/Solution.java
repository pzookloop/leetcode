package q0142;

import dataStruct.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode hd = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != null && slow != hd) {
                    slow = slow.next;
                    hd = hd.next;
                }
                return hd;
            }
        }
        return null;
    }
}
