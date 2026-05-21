package q0143;

import dataStruct.ListNode;

import static dataStruct.ListNode.construct;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode midNode = findMidNode(head);
        ListNode l1 = head;
        // 反转链表要将起点返回头节点 pre
        ListNode l2 = reverseList(midNode);
        while (l1.next != l2 && l1 != l2) {
            ListNode l1Nxt = l1.next;
            ListNode l2Nxt = l2.next;

            l1.next = l2;
            l2.next = l1Nxt;
            l1 = l1Nxt;
            l2 = l2Nxt;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = null;
        ListNode cur = dummy.next;

        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private ListNode findMidNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return slow;
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
