package q0104;

import dataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int maxDepth(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ans+=1;
            Queue<TreeNode> level = new ArrayDeque<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) break;
                if (node.left != null) level.offer(node.left);
                if (node.right != null) level.offer(node.right);
            }
            queue = level;
        }

        return ans;
    }
}
