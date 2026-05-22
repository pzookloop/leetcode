package q0111;

import dataStruct.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftMin = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightMin = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
        return 1 + Math.min(leftMin, rightMin);
    }
}
