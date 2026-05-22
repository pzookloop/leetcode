package q0404;

import dataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode peak = queue.poll();
            if (peak.left != null) {
                queue.add(peak.left);
                if (peak.left.left == null && peak.left.right == null) {
                    ans += peak.left.val;
                }
            }
            if (peak.right != null) {
                queue.add(peak.right);
            }
        }

        return ans;
    }
}
