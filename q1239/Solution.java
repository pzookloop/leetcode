package q1239;

import java.util.*;

public class Solution {
    private int ans = 0;
    private int curLen = 0;
    private int n = 0;
    private static final Map<Character, Boolean> alphabet = new HashMap<>();
    static {
        // 自动循环生成 a-z 26个小写字母，value 全部为 false
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.put(c, false);
        }
    }

    public int maxLength(List<String> arr) {
        n = arr.size();
        dfsInput(arr, 0);
        return ans;
    }

    private void dfsInput(List<String> arr, int i) {
        if (i == n) {
            ans = Math.max(ans, curLen);
            return;
        }
        dfsInput(arr, i+1);
        String curStr = arr.get(i);
        if (strNoDup(curStr) && curStrUniq(curStr)) {
            makeOrClean(curStr, true);
            int len = curStr.length();
            curLen += len;
            dfsInput(arr, i+1);
            curLen -= len;
            makeOrClean(curStr, false);
        }
    }

    private boolean strNoDup(String curStr) {
        Set<Character> st = new HashSet<>();
        for (char ch : curStr.toCharArray()) {
            if (st.contains(ch)) return false;
            st.add(ch);
        }
        return true;
    }

    private boolean curStrUniq(String curStr) {
        char[] chArr = curStr.toCharArray();
        for (char ch : chArr) {
            Boolean isDup = alphabet.getOrDefault(ch, false);
            if (isDup) {
                return false;
            }
        }
        return true;
    }

    private void makeOrClean(String curStr, Boolean flag) {
        char[] chArr = curStr.toCharArray();
        for (char ch : chArr) {
            alphabet.put(ch, flag);
        }
    }

    private void dfsOutput(List<String> arr, int i) {
        ans = Math.max(ans, curLen);
        if (i == n) return;
        for (int j = i; j < n; ++j) {
            String curStr = arr.get(j);
            if (strNoDup(curStr) && curStrUniq(curStr)) {
                makeOrClean(curStr, true);
                int len = curStr.length();
                curLen += len;
                dfsOutput(arr, j+1);
                curLen -= len;
                makeOrClean(curStr, false);
            }
        }
    }

    public static void main(String[] args) {
        List<String> arr = List.of("un","iq","ue");
        Solution s = new Solution();
        System.out.println(s.maxLength(arr));
    }
}
