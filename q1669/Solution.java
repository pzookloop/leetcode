package q1669;

import dataStruct.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode hd = list1;
        int m = b-a+1;
        while (a > 1) {
            list1 = list1.next;
            a--;
        }
        ListNode l1 = list1;
        while (m > 0) {
            l1 = l1.next;
            m--;
        }
        ListNode tail = l1.next;
        l1.next = null;
        list1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = tail;
        Map<Integer, Integer> mp = new HashMap<>();
        for (Map.Entry<Integer, Integer> ie : mp.entrySet()) {
            Integer value = ie.getValue();
        }
        return hd;
    }

    public static void main(String[] args) {
        int[] l1 = {10,1,13,6,9,5};
        int[] l2 = {1000000,1000001,1000002};
        int a = 3, b = 4;
        ListNode list1 = ListNode.construct(l1);
        ListNode list2 = ListNode.construct(l2);
        Solution s = new Solution();
        ListNode hd = s.mergeInBetween(list1, a, b, list2);
        while (hd != null) {
            System.out.println(hd.val);
            hd = hd.next;
        }
    }
}
