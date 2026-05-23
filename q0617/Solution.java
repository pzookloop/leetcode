package q0617;

import dataStruct.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        int val = root1.val + root2.val;
        TreeNode root = new TreeNode(val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
