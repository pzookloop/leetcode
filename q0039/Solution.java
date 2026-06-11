package q0039;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfsInput(0, 0, candidates, target, path, ans);
        return ans;
    }

    private void dfsInput(int i, int curSum, int[] candidates, int target,
                          List<Integer> path, List<List<Integer>> ans) {
        if (curSum > target || i >= candidates.length) return; //  || i >= candidates.length
        if (curSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (curSum+candidates[i] <= target) {
            path.add(candidates[i]);
            dfsInput(i, curSum+candidates[i], candidates, target, path, ans);
            path.removeLast();
        }
        dfsInput(i+1, curSum, candidates, target, path, ans);
    }

    private void dfsOutput(int i, int curSum, int[] candidates, int target,
                           List<Integer> path, List<List<Integer>> ans) {
        if (curSum > target) return;
        if (curSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            int curVal = candidates[j];
            if ((curVal + curSum) > target) continue;
            path.add(curVal);
            dfsOutput(j, curSum+curVal, candidates, target, path, ans);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ca = {8,7,4,3};
        int t = 11;
        System.out.println(s.combinationSum(ca, t));
    }

}
