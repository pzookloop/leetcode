package q1110;

import dataStruct.TreeNode;

import java.util.*;

public class Solution {
    private final List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return Collections.emptyList();
//        if(!dfs1(root, to_delete)) {
//            res.add(root);
//        }
        if (dfs2(root, to_delete) != null) {
            res.add(root);
        }
        return res;
    }

    private TreeNode dfs2(TreeNode root, int[] toDel) {
        if (root == null) return null;
        root.left = dfs2(root.left, toDel);
        root.right = dfs2(root.right, toDel);
        if (!isDel(root.val, toDel)) {
            return root;
        }
        if (root.left != null) {
            res.add(root.left);
            root.left = null;
        }
        if (root.right != null) {
            res.add(root.right);
            root.right = null;
        }
        return null;
    }

    private boolean dfs1(TreeNode root, int[] toDel) {
        if (root == null) return false;
        boolean leftDel = dfs1(root.left, toDel);
        boolean rightDel = dfs1(root.right, toDel);
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        if (leftDel) root.left = null;
        if (rightDel) root.right = null;
        if (!isDel(root.val, toDel)) {
            return false;
        } else {
            root.left = null;
            root.right = null;
            if (!leftDel && leftChild != null) res.add(leftChild);
            if (!rightDel && rightChild != null) res.add(rightChild);
            return true;
        }
    }

    private boolean isDel(int val, int[] toDel) {
        for (int td : toDel) {
            if (td == val) {
                return true;
            }
        }
        return false;
    }
}
