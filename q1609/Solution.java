package q1609;

import dataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean evenLvl = true;
        while (!queue.isEmpty()) {
            Queue<TreeNode> lvl = new ArrayDeque<>();
            TreeNode pre = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (evenLvl) {
                    if (node.val % 2 == 0) return false;
                    if (pre != null) {
                        if (pre.val >= node.val) return false;
                    }
                } else {
                    if (node.val % 2 == 1) return false;
                    if (pre != null) {
                        if (pre.val <= node.val) return false;
                    }
                }
                pre = node;
                if (node.left != null) lvl.offer(node.left);
                if (node.right != null) lvl.offer(node.right);
            }
            evenLvl = !evenLvl;
            queue = lvl;
        }
        return true;
    }
}
