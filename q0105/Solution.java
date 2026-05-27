package q0105;

import dataStruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        if(n == 0) return null;
//        int index = indexOf(inorder, preorder[0]);
//        if (index == -1) return null;
//        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
//        int[] rightInorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
//        int leftLen = leftInorder.length;
//        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftLen+1);
//        int[] rightPreorder = Arrays.copyOfRange(preorder, leftLen+1, n);
//        TreeNode root = new TreeNode(preorder[0]);
//        root.left = buildTree(leftPreorder, leftInorder);
//        root.right = buildTree(rightPreorder, rightInorder);
//        return root;
        int n = preorder.length;
        if (n == 0) return null;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return dfs(preorder, mp, 0, 0, n);
    }

    private TreeNode dfs(int[] preorder, Map<Integer, Integer> mp,
                         int poL, int ioL, int ioR) {
        if (ioL > ioR || poL == preorder.length) return null;
        int rootVal = preorder[poL];
        int idx = mp.getOrDefault(rootVal, -1);
        if (idx == -1) return null;
        int pLS = poL+1;
        int pRS = poL+1+idx-ioL;
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(preorder, mp, pLS, ioL, idx-1);
        root.right = dfs(preorder, mp, pRS, idx+1, ioR);
        return root;
    }


//    private int indexOf(int[] arr, int target) {
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == target) return i;
//        }
//        return -1;
//    }
}
