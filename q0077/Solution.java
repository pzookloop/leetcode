package q0077;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final List<Integer> path = new ArrayList<>();
    private final List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfsInput(n, k);
        return ans;
    }

    private void dfsInput(int i, int k) {
        if (i < k) return;
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfsInput(i-1, k);
        path.add(i);
        dfsInput(i-1, k-1);
        path.removeLast();
    }

    private void dfsR(int i, int k, int n) {
        int d = n-i+1;
        if (d < k) return;
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfsR(i+1, k, n);
        path.add(i);
        dfsR(i+1, k-1, n);
        path.removeLast();
    }

    private void dfsOutput(int i, int k) {
        if (i < k) return;
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j > 0; --j) {
            path.add(j);
            dfsOutput(j-1, k-1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4, k = 2;
        System.out.println(s.combine(n, k));
    }
}
