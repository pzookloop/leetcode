package q0093;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> path = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        dfsOutput(0, 0, 4, s, path, ans);

        return ans;
    }

    private void dfsOutput(int i, int start, int pointCnt, String s, List<String> path, List<String> ans) {
        if (i > s.length() || pointCnt < 0) return;
        if (i == s.length()) {
            if (pointCnt == 0) {
                ans.add(String.join(".", path));
            }
            return;
        }
        if (i < s.length()-1) {
            dfsOutput(i+1, start, pointCnt, s, path, ans);
        }
        String str = s.substring(start, i+1);
        if (check(str)) {
            path.add(str);
            dfsOutput(i+1, i+1, pointCnt-1, s, path, ans);
            path.removeLast();
        };
    }


    private void dfsInput(int i, int start, int pointCnt, String s, List<String> path, List<String> ans) {
        if (i > s.length() || pointCnt < 0) return;
        if (i == s.length()) {
            if (pointCnt == 0) {
                ans.add(String.join(".", path));
            }
            return;
        }
        for (int j = i; j < s.length(); ++j) {
            String str = s.substring(start, j+1);
            if (check(str)) {
                path.add(str);
                dfsInput(j+1, j+1, pointCnt-1, s, path, ans);
                path.removeLast();
            } else break;
        }
    }

    private boolean check(String str) {
        // 1. 不允许先导 0
        boolean zeroStart = zeroStart(str);
        // 2. 范围为 0-255
        boolean validNumber = validNumber(str);
        return !zeroStart && validNumber;
    }

    private boolean zeroStart(String str) {
        if (str == null) return true;
        if (str.length() == 1) return false;
        return "0".equals(str.substring(0,1));
    }

    private boolean validNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            return number >= 0 && number <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"25525511135", "0000", "101023"};
        for (String str : strs) {
            System.out.println(s.restoreIpAddresses(str));
        }
    }
}