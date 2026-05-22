package q0987;

import dataStruct.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // key是列, value是节点值, 从上到下, 天然有序
        Map<Integer, List<List<Integer>>> mp = new HashMap<>();
        dfs(root, 0, 0, mp);
        List<List<Integer>> res = new ArrayList<>();
        // 从左到右遍历每一列
        for (int i = -1000; i < 1001; ++i) {
            List<List<Integer>> ls = mp.getOrDefault(i, null);
            if (ls != null) {
                ls.sort((a, b) -> {
                    int valA = a.getFirst();
                    int xA = a.get(1);
                    int vblB = b.getFirst();
                    int xB = b.get(1);
                    if (xA == xB) return valA - vblB;
                    return xA - xB;
                });
                List<Integer> tmp = new ArrayList<>();
                for (List<Integer> ll : ls) {
                    tmp.add(ll.getFirst());
                }
                res.add(tmp);
            }
        }

        return res;
    }


    // x 行, y 列
    private void dfs(TreeNode root, int x, int y, Map<Integer, List<List<Integer>>> mp) {
        if (root == null) return;
        List<List<Integer>> list = mp.getOrDefault(y, new ArrayList<>());
        list.add(List.of(root.val, x));
        mp.put(y, list);
        dfs(root.left, x+1, y-1, mp);
        dfs(root.right, x+1, y+1, mp);
    }
}
