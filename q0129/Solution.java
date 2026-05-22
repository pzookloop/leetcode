package q0129;

import dataStruct.TreeNode;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val);
    }


    private int dfs(TreeNode root, int upperVal) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return upperVal;
        int leftSum = root.left != null ?
                dfs(root.left, upperVal * 10 + root.left.val) : 0;
        int rightSum = root.right != null ?
                dfs(root.right, upperVal * 10 + root.right.val): 0;
        return leftSum + rightSum;
    }
}
