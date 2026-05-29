package q0111;

import dataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution {
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        if (root.left == null && root.right == null) return 1;
//        int leftMin = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
//        int rightMin = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
//        return 1 + Math.min(leftMin, rightMin);
//    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> level = new ArrayDeque<>();
            int size = queue.size();
            ans += 1;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null ||
                        (node.left == null && node.right == null))
                    return ans;
                if (node.left != null) level.offer(node.left);
                if (node.right != null) level.offer(node.right);
            }
            queue = level;
        }
        return ans;
    }
}
