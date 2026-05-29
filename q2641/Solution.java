package q2641;

import dataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        root.val = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<List<TreeNode>> lvl = new ArrayList<>();
            List<Integer> lvlSum = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                assert node != null;
                List<TreeNode> nodes = new ArrayList<>();
                int childSum = 0;
                if (node.left != null) {
                    sum += node.left.val;
                    childSum += node.left.val;
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    sum += node.right.val;
                    childSum += node.right.val;
                    nodes.add(node.right);
                }
                lvlSum.add(childSum);
                lvl.add(nodes);
            }
            queue = new ArrayList<>();
            for (int i = 0; i < lvl.size(); i++) {
                List<TreeNode> treeNodes = lvl.get(i);
                for (TreeNode treeNode : treeNodes) {
                    treeNode.val = sum - lvlSum.get(i);
                    queue.add(treeNode);
                }
            }
        }
        return root;
    }
}
