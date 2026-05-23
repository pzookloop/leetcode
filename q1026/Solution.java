package q1026;

import dataStruct.TreeNode;

public class Solution {
    private int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    private void dfs(TreeNode root, int minVal, int maxVal) {
        if (root == null) return;
        maxDiff = Math.max(Math.max(maxDiff, Math.abs(maxVal-root.val)), Math.abs(root.val-minVal));
        minVal = Math.min(minVal, root.val);
        maxVal = Math.max(maxVal, root.val);
        dfs(root.left, minVal, maxVal);
        dfs(root.right, minVal, maxVal);
    }
}
