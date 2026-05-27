package q0106;

import dataStruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 0) return null;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return dfs(postorder, mp, n-1, 0, n-1);
    }

    private TreeNode dfs(int[] postorder, Map<Integer, Integer> m,
                         int poS, int inS, int inE) {
        if (inE < inS) return null;
        TreeNode root = new TreeNode(postorder[poS]);
        if (inE == inS) return root;
        int idx = m.getOrDefault(postorder[poS], -1);
        if (idx == -1) return null;
        int rightLen = inE-idx;
        int inLE = idx-1;
        int inRS = idx+1;
        int poRS = poS-1, poLS = poRS-rightLen;
        root.left = dfs(postorder, m, poLS, inS, inLE);
        root.right = dfs(postorder, m, poRS, inRS, inE);
        return root;
    }
}
