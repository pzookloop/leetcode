package q1080;

import dataStruct.TreeNode;

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (root.val < limit) return null;
            else return root;
        }
        TreeNode leftSubTree = dfs(root.left, limit, root.val);
        TreeNode rightSubTree = dfs(root.right, limit, root.val);
        if (leftSubTree == null) root.left = null;
        if (rightSubTree == null) root.right = null;
        if (leftSubTree == null && rightSubTree == null) return null;
        return root;
    }


    private TreeNode dfs(TreeNode root, int limit, int preSum) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            int sum = root.val + preSum;
            if (sum < limit) return null;
            else return root;
        }
        TreeNode leftSubTree = dfs(root.left, limit, preSum+root.val);
        TreeNode rightSubTree = dfs(root.right, limit, preSum+root.val);
        if (leftSubTree == null) root.left = null;
        if (rightSubTree == null) root.right = null;
        if (leftSubTree == null && rightSubTree == null) return null;
        return root;
    }
}
