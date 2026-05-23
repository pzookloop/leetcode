package q0508;

import dataStruct.TreeNode;

import java.util.*;

public class Solution {
    private int maxOcc = 0;
    private final Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v >= maxOcc) res.add(k);
        });
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int sum = root.val + leftSum + rightSum;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxOcc = Math.max(map.getOrDefault(sum, 0), maxOcc);
        return sum;
    }


    public static void main(String[] args) {
        Solution root = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = null;
        int[] res = root.findFrequentTreeSum(treeNode);
        System.out.println(Arrays.toString(res));
    }
}
