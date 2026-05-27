package q1373;

import dataStruct.TreeNode;

public class Solution {
    private int ans = 0;
    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans;
    }


    // int[] arr = {子树最小值, 子树最大值, 子树节点值和}
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] leftInfo = dfs(root.left);
        int[] rightInfo = dfs(root.right);
        int x = root.val;
        if (x <= leftInfo[1] || x >= rightInfo[0]) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int sum = x + leftInfo[2] + rightInfo[2];
        ans = Math.max(ans, sum);
        return new int[]{Math.min(leftInfo[0], x), Math.max(rightInfo[1], x), sum}; // 注释1: 单节点或者叶子节点情况下要这样排除-∞和+∞
//        return new int[]{leftInfo[0], rightInfo[0], sum}; // 注释2
    }
}
