package q2583;

import dataStruct.TreeNode;

import java.util.*;

public class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        List<Long> levelSum = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        long curLvlSum = root.val;
        while (!queue.isEmpty()) {
            levelSum.add(curLvlSum);
            curLvlSum = 0L;
            Queue<TreeNode> lvl = new ArrayDeque<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    curLvlSum += node.left.val;
                    lvl.offer(node.left);
                }
                if (node.right != null) {
                    curLvlSum += node.right.val;
                    lvl.offer(node.right);
                }
            }
            queue = lvl;
        }
        if (k > levelSum.size()) return -1;
        levelSum.sort(Comparator.reverseOrder());
        return levelSum.get(k-1);
    }
}
