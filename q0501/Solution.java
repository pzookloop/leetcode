package q0501;

import dataStruct.TreeNode;

import java.util.*;

public class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> mp = new HashMap<>();
        dfs(root, mp);

        List<Integer> ansList = new ArrayList<>();
        int maxOcc = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            Integer elm = entry.getKey();
            Integer occNum = entry.getValue();
            if (occNum == maxOcc) {
                ansList.add(elm);
            } else if (occNum > maxOcc) {
                maxOcc = occNum;
                ansList = new ArrayList<>();
                ansList.add(elm);
            }
        }

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }


    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
    }
}
