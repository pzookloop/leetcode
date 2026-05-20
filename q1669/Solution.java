package q1669;

import dataStruct.ListNode;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1, list1);
        ListNode pre = dummy;
        for (int i = 0; i < a; ++i) {
            pre = pre.next;
        }
        ListNode preNxt = pre.next;
        pre.next = list2;

        int cnt = b-a;
        while (list2.next != null || cnt > 0) {
            if (cnt > 0) {
                preNxt = preNxt.next;
                cnt -= 1;
            }
            if (list2.next != null) {
                list2 = list2.next;
            }
        }

        ListNode l1E = preNxt.next;
        preNxt.next = null;

        list2.next = l1E;

        return dummy.next;
    }
}
