package q0017;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String[] alphabet = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private int len;
    private final List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        StringBuilder path = new StringBuilder();
        len = digits.length();
        if (len == 0) return ans;
        dfs(digits, path, 0);
        return ans;
    }

    private void dfs(String digits, StringBuilder path, int i) {
        if (i == len) {
            ans.add(path.toString());
            return;
        }
        char[] nums = digits.toCharArray();
        int idx = nums[i]-'0';
        String str = alphabet[idx];
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            path.append(c);
            dfs(digits, path, i + 1);
            path.deleteCharAt(i);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String digit = "23";
        System.out.println(s.letterCombinations(digit));
    }
}
