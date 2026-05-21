package q0142;

import dataStruct.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head, h = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                h = head;
                while (slow != h) {
                    slow = slow.next;
                    h = h.next;
                }

                return h;
            }
        }


        return h;
    }
}
