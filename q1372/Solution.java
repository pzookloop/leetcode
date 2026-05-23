package q1372;

import dataStruct.TreeNode;

public class Solution {
    private int ans = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        // 左: -1, 右: 1
        dfs(root.left, -1, 1);
        dfs(root.right, 1, 1);
        return ans;
    }

    private void dfs(TreeNode root, int dir, int deep) {
        // 左: -1, 右: 1
        if (root == null) return;
        ans = Math.max(ans, deep);
        if (dir == -1) {
            dfs(root.right, 1, deep+1);
            dfs(root.left, -1, 1);
        }
        if (dir == 1) {
            dfs(root.left, -1, deep+1);
            dfs(root.right, 1, 1);
        }
    }
}
