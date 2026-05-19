package q2816;

import dataStruct.ListNode;

public class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode cur = reverse(head);
        ListNode pre = null;
        int extra = 0, sum, val;
        while (cur != null) {
            sum = extra + 2 * cur.val;
            val = sum % 10;
            extra = sum / 10;
            cur.val = val;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (extra > 0) {
            pre = new ListNode(extra, pre);
        }

        return pre;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
