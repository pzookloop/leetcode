package q0113;

import dataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum,
                     ArrayDeque<Integer> path, List<List<Integer>> ans) {
        if (root == null) return;
        path.offer(root.val);
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (Integer p : path) {
                sum += p;
            }
            if (sum == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, targetSum, path, ans);
        dfs(root.right, targetSum, path, ans);
        path.pollLast();
    }
}
