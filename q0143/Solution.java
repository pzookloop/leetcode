package q0143;

import dataStruct.ListNode;

import static dataStruct.ListNode.construct;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode midNode = findMidNode(head);
        ListNode reHd = reverseList(midNode);
        ListNode h1 = head;
        ListNode h2 = reHd;
        while (h1 != null && h1.next != h2 && h2 != null) {
            ListNode h1Nxt = h1.next;
            ListNode h2Nxt = h2.next;
            h1.next = h2;
            h2.next = h1Nxt;
            h1 = h1Nxt;
            h2 = h2Nxt;
        }
    }

    private ListNode reverseList(ListNode head) {
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

    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution s = new Solution();
        ListNode head = construct(nums);
        s.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
