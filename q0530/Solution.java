package q0530;

import dataStruct.TreeNode;

public class Solution {
    private int ans = Integer.MAX_VALUE;
    private int pre = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        ans = Math.min(ans, Math.abs(root.val-pre));
        pre = root.val;
        dfs(root.right);
    }
}
