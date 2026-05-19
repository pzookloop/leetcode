package dataStruct;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode construct(int[] nums) {
        ListNode head = null;
        ListNode tail = null;
        for (int num : nums) {
            ListNode node = new ListNode(num, null);
            if (head == null) {
                head = node;
                tail = node;
                continue;
            }
            tail.next = node;
            tail = node;
        }

        return head;
    }
}
