package q0230;

import dataStruct.TreeNode;

public class Solution {

    private int cnt = 0;
    private int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null || ans > 0) {
            return;
        }
        dfs(root.left, k);
        cnt++;
        if (k-cnt == 0) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
