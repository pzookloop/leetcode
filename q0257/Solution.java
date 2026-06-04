package q0257;

import dataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfsOutPut(root, path, ans);
        return ans;
    }

    private void dfsOutPut(TreeNode root, ArrayDeque<Integer> path,
                           List<String> ans) {
        if (root == null) {
            return;
        }
        path.offer(root.val);
        if (root.left == null && root.right == null) {
            ans.add(path.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("->")));
        }
        dfsOutPut(root.left, path, ans);
        dfsOutPut(root.right, path, ans);
        path.pollLast();
    }
}
