package q0083;

import dataStruct.ListNode;

import static dataStruct.ListNode.construct;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
//        ListNode next = head.next;
//        while (next != null) {
//            while (next != null && next.val == cur.val) {
//                next = next.next;
//            }
//            cur.next = next;
//            if (next != null) {
//                cur = next;
//                next = next.next;
//            }
//        }
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,2,3,3};
        ListNode head = construct(nums);
        ListNode hd = s.deleteDuplicates(head);
        while (hd != null) {
            System.out.println(hd.val);
            hd = hd.next;
        }
    }
}
