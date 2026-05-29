package q0107;

import dataStruct.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = deque.poll();
                level.add(n.val);
                if (n.left != null) {
                    deque.offer(n.left);
                }
                if (n.right != null) {
                    deque.offer(n.right);
                }
            }
            if (!level.isEmpty()) {
                ans.addFirst(level);
            }
        }
        return ans;
    }
}
