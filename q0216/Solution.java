package q0216;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final List<Integer> path = new ArrayList<>();
    private final List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfsR(1, k, n);
        return ans;
    }

    private void dfsR(int i, int k, int t) {
        if (k == 0) {
            if (t == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        // 不要调换代码位置, 和上面的if, 因为i==10的情况要获取答案
        if (i > 9 || k > 10-i) return;
        path.add(i);
        dfsR(i+1, k-1, t-i);
        path.removeLast();
        dfsR(i+1, k, t);
    }

    private void dfsInput(int i, int k, int t) {
        if (i < 0) return;
        if (t < 0 || t > ((i+i-k+1)*k >>> 1)) {
            return;
        }
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfsInput(i-1, k, t);
        path.add(i);
        dfsInput(i-1, k-1, t-i);
        path.removeLast();
    }

    private void dfsOutput(int i, int k, int t) {
        if (t < 0 || t > ((i + i-k+1) * k >>> 1)) {
            return;
        }
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j > 0; --j) {
            path.add(j);
            dfsOutput(j-1, k-1, t-j);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int k = 9, n = 45;
        System.out.println(s.combinationSum3(k, n));
    }
}
