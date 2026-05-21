package q0025;

import dataStruct.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        int sum = 0;
        while (head != null) {
            sum += 1;
            head = head.next;
        }

        ListNode p0 = dummy;
        while (sum >= k) {
            sum -= k;
            ListNode pre = null;
            ListNode cur = p0.next;
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }

            ListNode next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }

        return dummy.next;
    }
}
