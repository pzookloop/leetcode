package q2476;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();
        // 中序遍历获取有序数组
        dfs(root, arr);
        int n = arr.size();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = arr.get(i); // 自动拆箱 (Unboxing)
        }
        List<List<Integer>> ans = new ArrayList<>();
        // 二分
        for (Integer query : queries) {
            // 大于等于qNum最小值
            int maxIdx = search(nodes, query);
            // 小于等于qNum的最大值
            int minIdx = search(nodes, query + 1);
            ans.add(Arrays.asList(minIdx-1 > -1 ? nodes[minIdx-1] : -1,
                    maxIdx == nodes.length ? -1 : nodes[maxIdx]));
        }
        return ans;
    }

    // >= target的最小值下标
    private int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }
}
