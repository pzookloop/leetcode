package q2130;

import dataStruct.ListNode;

import static dataStruct.ListNode.construct;

public class Solution {
    public int pairSum(ListNode head) {
        int ans = 0;
        ListNode midNode = findMidNode(head);
        ListNode midReverse = reverseList(midNode);
        // 1->1->[2]<-3
        while (midReverse != null) {
            ans = Math.max(head.val+ midReverse.val, ans);
            midReverse = midReverse.next;
            head = head.next;
        }

        return ans;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,100000};
        ListNode head = construct(nums);
        Solution s = new Solution();
        System.out.println(s.pairSum(head));
    }
}
