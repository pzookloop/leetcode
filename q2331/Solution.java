package q2331;

import dataStruct.TreeNode;

public class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null  && root.right == null) {
            return root.val == 1;
        }
        boolean leftVal = root.left == null ||
                evaluateTree(root.left);
        boolean rightVal = root.right == null ||
                evaluateTree(root.right);
        return root.val == 2 ? leftVal || rightVal : leftVal && rightVal;
    }
}
