package q0078;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfsOutput(nums, path, ans, 0);
        return ans;
    }

    private void dfsOutput(int[] nums, Deque<Integer> path,
                           List<List<Integer>> ans, int i) {
        ans.add(new ArrayList<>(path));
        if (i == nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            path.offer(nums[j]);
            dfsOutput(nums, path, ans, j+1);
            path.pollLast();
        }
    }

    private void dfsInput(int[] nums, Deque<Integer> path,
                          List<List<Integer>> ans, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        path.offer(nums[i]);
        dfsInput(nums, path, ans, i+1);
        path.pollLast();
        dfsInput(nums, path, ans, i+1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1, 2, 3};
        System.out.println(s.subsets(arr));
    }
}
