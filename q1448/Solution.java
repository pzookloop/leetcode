package q1448;

import dataStruct.TreeNode;

public class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int[] ans = {0};
        dfs(root, root.val, ans);
        return ans[0];
    }

    private void dfs(TreeNode root, int curMax, int[] ans) {
        if (root == null) return;
        if (root.val >= curMax) ans[0] += 1;
        dfs(root.left, Math.max(curMax, root.val), ans);
        dfs(root.right, Math.max(curMax, root.val), ans);
    }
}
