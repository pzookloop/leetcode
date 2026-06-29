package q2130;

import dataStruct.ListNode;

import static dataStruct.ListNode.construct;

public class Solution {
    public int pairSum(ListNode head) {
        // 找到中间节点
        ListNode slow = head, fast = head;
        ListNode pre = null, cur = slow;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur;
            cur = slow;
        }
        // 1 2 3 4 5
        if (fast != null) {
            cur = cur.next;
        }

        int max = 0;
        while (cur != null && pre != null) {
            int sum = cur.val + pre.val;
            max = Math.max(max, sum);
            cur = cur.next;
            pre = pre.next;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,2,3};
        ListNode head = construct(nums);
        Solution s = new Solution();
        System.out.println(s.pairSum(head));
    }
}
