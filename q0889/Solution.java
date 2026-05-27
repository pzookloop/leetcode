package q0889;

import dataStruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> mp = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        if(n == 0) return null;
        for (int i = 0; i < n; i++) {
            mp.put(postorder[i], i);
        }
        return dfs(preorder, mp, 0, n-1, 0);
    }

    private TreeNode dfs(int[] preorder, Map<Integer, Integer> mp,
                         int prS, int prE, int poS) {
        if (prS > prE) return null;
        if (prS == prE) return new TreeNode(preorder[prS]);
        int idx = mp.getOrDefault(preorder[prS+1], -1);
        if (idx == -1) return null;
        int leftSize = idx-poS+1;
        TreeNode root = new TreeNode(preorder[prS]);
        int preSL = prS+1, preEL = preSL+leftSize-1;
        int preSR = preEL+1;
        int posR = idx+1;
        root.left = dfs(preorder, mp, preSL, preEL, poS);
        root.right = dfs(preorder, mp, preSR, prE, posR);
        return root;
    }
}
