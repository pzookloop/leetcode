package q1123;

import dataStruct.TreeNode;

public class Solution {
    private int maxDp = -1;
    private TreeNode ans;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            maxDp = Math.max(maxDp, deep);
            return deep;
        }
        int leftDp = dfs(root.left, deep+1);
        int rightDp = dfs(root.right, deep+1);
        if (leftDp == rightDp && leftDp == maxDp) {
            ans = root;
            return leftDp;
        }
        return Math.max(leftDp, rightDp);
    }
}
