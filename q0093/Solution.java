package q0093;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> path = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfsInput(s, path, 0, 0, 0, ans);
//        dfsOutput(s, path, 0, 0, ans);
        return ans;
    }

    private void dfsInput(String s, List<String> path, int start, int i, int curPoint, List<String> ans) {
        if (curPoint > 4) return;
        if (i == s.length()) {
            if (curPoint == 4) {
                ans.add(String.join( ".", path));
            }
            return;
        }
        if (!canSplit(s, start, i)) return;
        if (maxThan255(s, start, i)) return;
        if (i < s.length()-1) {
            dfsInput(s, path, start, i+1, curPoint, ans);
        }
        path.add(s.substring(start, i+1));
        dfsInput(s, path, i+1, i+1, curPoint+1, ans);
        path.removeLast();
    }

    private boolean maxThan255(String str, int i, int j) {
        String substring = str.substring(i, j + 1);
        try {
            long curNum = Long.parseLong(substring);
            return curNum > 255;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean canSplit(String str, int i, int j) {
        String substring = str.substring(i, j + 1);
        return substring.length() <= 1 || str.charAt(i) != '0';
    }

    private void dfsOutput(String s, List<String> path, int i, int curPoint, List<String> ans) {
        if (curPoint > 4) return;
        if (i == s.length()) {
            if (curPoint == 4) {
                ans.add(String.join( ".", path));
            }
            return;
        }
        for (int j = i; j < s.length(); ++j) {
            if (maxThan255(s, i, j)) {
                break;
            }
            if (canSplit(s, i, j)) {
                path.add(s.substring(i, j+1));
                dfsOutput(s, path, j+1, curPoint+1, ans);
                path.removeLast();
            } else {
                break;
            }
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