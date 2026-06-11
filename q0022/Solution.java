package q0022;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final List<String> ans = new ArrayList<>();
    private final List<Character> path = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        for (int i = 0; i < n * 2; i++) path.add('0');
        dfsOutput(0, 0, n * 2, n);
        return ans;
    }

    private void dfsOutput(int i, int open, int m, int n) {
        if (i > m) return;
        if (i == m) {
            StringBuilder str = new StringBuilder();
            for (Character ch : path) {
                str.append(ch);
            }
            ans.add(str.toString());
            return;
        }
        if (open < n) {
            path.add('(');
            dfsOutput(i+1, open+1, m, n);
            path.removeLast();
        }
        int close = i - open;
        if (close < open) {
            path.add(')');
            dfsOutput(i+1, open, m, n);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;
        System.out.println(s.generateParenthesis(n));
    }
}
