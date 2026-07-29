package q0103;

import dataStruct.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return Collections.emptyList();
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.offer(root);
        boolean even = false;
        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int curLen = q.size();
            while(curLen > 0) {
                curLen -= 1;
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            if(even) {
                Collections.reverse(tmp);
            }
            even = !even;
            ans.add(tmp);
        }
        return ans;
    }
}
