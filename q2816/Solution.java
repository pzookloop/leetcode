package q2816;

import dataStruct.ListNode;

public class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode h = reverse(head);
        ListNode dummy = new ListNode(-1, null);
        int extra = 0;
        while (h != null) {
            int val = 2 * h.val + extra;
            extra = val / 10;
            dummy.next = new ListNode(val % 10, dummy.next);
            h = h.next;
        }
        if (extra > 0) {
            dummy.next = new ListNode(extra, dummy.next);
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode cur) {
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
