package q0234;

import dataStruct.ListNode;

import static dataStruct.ListNode.construct;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        int num = 0;
        ListNode hd = head;
        while (hd != null) {
            num += 1;
            hd = hd.next;
        }
        if (num == 1) return true;
        int mid = num % 2 == 0 ? (num / 2) : (num / 2 + 1);
        ListNode midNode = head;
        while (mid > 0) {
            mid -= 1;
            midNode = midNode.next;
        }
        ListNode reHd = reverseList(midNode);
        while (reHd != null) {
            if (reHd.val != head.val) return false;
            reHd = reHd.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode midNode) {
        ListNode pre = null;
        ListNode cur = midNode;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
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
