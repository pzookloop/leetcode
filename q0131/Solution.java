package q0131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, path, ans, 0);
        return ans;
    }

    private void dfs(String s, List<String> path, List<List<String>> ans, int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length(); ++j) {
            if (isPalindrome(s, i, j)) {
                String subStr = s.subSequence(i, j + 1).toString();
                path.add(subStr);
                dfs(s, path, ans, j+1);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
