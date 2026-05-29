package q2415;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        boolean odd = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (odd) {
                int i = 0, j = size-1;
                while (i < j) {
                    TreeNode n = queue.get(i);
                    TreeNode m = queue.get(j);
                    int tmp = n.val;
                    n.val = m.val;
                    m.val = tmp;
                    ++i;
                    --j;
                }
            }
            List<TreeNode> lvl = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) lvl.add(node.left);
                if (node.right != null) lvl.add(node.right);
            }
            queue = lvl;
            odd = !odd;
        }
        return root;
    }
}
