package q0445;

import dataStruct.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rL1 = reverse(l1);
        ListNode rL2 = reverse(l2);
        int extra = 0, sum, val;
        ListNode curL1 = rL1, curL2 = rL2;
        ListNode res = null;
        while (curL1 != null || curL2 != null) {
            sum = (curL1 != null ? curL1.val : 0) +
                    (curL2 != null ? curL2.val : 0);
            val = (sum + extra) % 10;
            extra = (sum + extra) / 10;
            res = new ListNode(val, res);
            curL1 = curL1 != null ? curL1.next : null;
            curL2 = curL2 != null ? curL2.next : null;
        }

        if (extra > 0) {
            res = new ListNode(extra, res);
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        assert head != null;
        ListNode cur = head;
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
