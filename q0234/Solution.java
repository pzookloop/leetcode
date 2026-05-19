package q0234;

import dataStruct.ListNode;

import static dataStruct.ListNode.construct;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        int sum = 0;
        ListNode cur = head;
        while (cur != null) {
            sum += 1;
            cur = cur.next;
        }

        int mid = sum / 2 + (sum % 2 == 0 ? 1 : 2);
        ListNode l2 = reverseList(head, mid, sum);
        ListNode l1 = head;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head, int left, int right) {
        ListNode p0 = new ListNode(-1, head);
        for (int i = 1; i < left; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;
        for (int i = 0; i < right-left+1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        p0.next.next = cur;
        p0.next = pre;

        return pre;
    }

//    private ListNode findMidNode(ListNode head) {
//        ListNode slow = head, fast = head;
//        // 1 1 2 2
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return slow;
//    }

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        ListNode head = construct(nums);
        Solution s = new Solution();
        System.out.println(s.isPalindrome(head));
    }
}
