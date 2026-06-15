package q2850;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumMoves(int[][] grid) {
        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 1) {
                    for (int k = 1; k < grid[i][j]; ++k) {
                        from.add(new int[]{i, j});
                    }
                } else if (grid[i][j] == 0) {
                    to.add(new int[]{i, j});
                }
            }
        }

        List<List<int[]>> fromAllRange = permutations(from);
        int ans = Integer.MAX_VALUE;
        for (List<int[]> fromRange : fromAllRange) {
            int total = 0;
            for (int i = 0; i < fromRange.size(); i++) {
                int[] f = fromRange.get(i);
                int[] t = to.get(i);
                total += Math.abs(t[0]-f[0]) + Math.abs(t[1]-f[1]);
            }
            ans = Math.min(ans, total);
        }

        return ans;
    }

    private List<List<int[]>> permutations(List<int[]> from) {
        List<List<int[]>> res = new ArrayList<>();
        permute(0, from, res);
        return res;
    }

    private void permute(int start, List<int[]> arr, List<List<int[]>> res) {
        if (start == arr.size()) {
            res.add(new ArrayList<>(arr));
            return;
        }

        for (int i = start; i < arr.size(); ++i) {
            swap(arr, start, i);
            permute(start+1, arr, res);
            swap(arr, i, start);
        }
    }

    private void swap(List<int[]> arr, int from, int to) {
        int[] tmp = arr.get(from);
        arr.set(from, arr.get(to));
        arr.set(to, tmp);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1,1,0}, {1,1,1}, {1,2,1}};
        System.out.println(s.minimumMoves(grid));
    }
}
