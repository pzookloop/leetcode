package q0092;

import dataStruct.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;
        for (int i = 0; i < left-1; i++) {
            p0 = p0.next;
        }
        ListNode pre = p0;
        ListNode cur = p0.next;
        int range = right-left+1;
        for (int i = 0; i < range; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
}
