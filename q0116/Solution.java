package q0116;

import dataStruct.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<Node> lvl = new ArrayDeque<>();
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                if (n.left != null) {
                    if (pre != null) {
                        pre.next = n.left;
                    }
                    pre = n.left;
                    lvl.offer(n.left);
                }
                if (n.right != null) {
                    if (pre != null) {
                        pre.next = n.right;
                    }
                    pre = n.right;
                    lvl.offer(n.right);
                }
            }
            queue = lvl;
        }
        return root;
    }
}
