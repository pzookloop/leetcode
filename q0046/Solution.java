package q0046;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private final Map<Integer, Boolean> vis = new HashMap<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            Boolean isVis = vis.getOrDefault(num, false);
            if (!isVis) {
                path.add(num);
                vis.put(num, true);
                dfs(nums, i+1);
                vis.put(num, false);
                path.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        System.out.println(s.permute(nums));
    }
}
