package q0445;

import dataStruct.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d1 = reverse(l1);
        ListNode d2 = reverse(l2);
        ListNode head = new ListNode(-1, null);
        int extra = 0;
        while (d1 != null || d2 != null) {
            int sum = 0;
            if (d1 != null) {
                sum += d1.val;
                d1 = d1.next;
            }
            if (d2 != null) {
                sum += d2.val;
                d2 = d2.next;
            }
            sum += extra;
            extra = sum / 10;
            head.next = new ListNode(sum % 10, head.next);
        }
        if (extra > 0) {
            head.next = new ListNode(extra, head.next);
        }
        return head.next;
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
