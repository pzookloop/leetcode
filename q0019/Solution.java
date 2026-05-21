package q0019;

import dataStruct.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode l1 = dummy, l2 = dummy;
        for (int i = 0; i < n; i++) {
            l2 = l2.next;
        }

        while (l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }

        l1.next = l1.next.next;

        return dummy.next;
    }
}
