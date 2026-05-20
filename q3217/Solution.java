package q3217;

import dataStruct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // 预先初始化容量可以进一步优化性能：容量 = 数组长度 / 0.75f + 1
        Set<Integer> set = new HashSet<>((int)(nums.length / 0.75f) + 1);
        for (int num : nums) {
            set.add(num); // 自动装箱
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
