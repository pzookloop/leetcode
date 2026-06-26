package q0024;

import dataStruct.ListNode;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        int n = 0;
        ListNode tp = head;
        while (tp != null) {
            n += 1;
            tp = tp.next;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;
        while (n >= 2) {
            n -= 2;
            ListNode pre = null;
            ListNode cur = p0.next;
            for (int i = 0; i < 2; ++i) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            ListNode nxt = p0.next;
            assert p0.next != null;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
}
