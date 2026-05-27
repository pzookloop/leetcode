package q0938;

import dataStruct.TreeNode;

public class Solution {

    private int ans = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ans;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) return;
        if (root.val >= low && root.val <= high) {
            ans += root.val;
            dfs(root.left, low, high);
            dfs(root.right, low, high);
        } else {
            if (root.val < low) dfs(root.right, low, high);
            if (root.val > high) dfs(root.left, low, high);
        }
    }
}
