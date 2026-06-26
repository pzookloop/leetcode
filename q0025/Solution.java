package q0025;

import dataStruct.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy.next;
        int n = 0;
        while (p0 != null) {
            ++n;
            p0 = p0.next;
        }
        p0 = dummy;
        while (n >= k) {
            n -= k;
            ListNode pre = p0;
            ListNode cur = p0.next;
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode p = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = p;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.construct(nums);
        int k = 2;
        Solution s = new Solution();
        System.out.println(s.reverseKGroup(head, k));
    }
}
