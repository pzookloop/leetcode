package q1302;

import dataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> lvl = new ArrayDeque<>();
            int ans = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ans += node.val;
                if (node.left != null) {
                    lvl.add(node.left);
                }
                if (node.right != null) {
                    lvl.add(node.right);
                }
            }
            if (lvl.isEmpty()) {
                return ans;
            }
            queue = lvl;
        }

        return 0;
    }
}
