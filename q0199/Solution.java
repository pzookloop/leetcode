package q0199;

import dataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            Queue<TreeNode> lvl = new ArrayDeque<>();
            int size = queue.size();
            ans.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) lvl.offer(node.right);
                if (node.left != null) lvl.offer(node.left);
            }
            queue = lvl;
        }

        return ans;
    }
}
