package q0237;

import dataStruct.ListNode;

public class Solution {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
