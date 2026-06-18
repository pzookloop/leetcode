package q0076;

import java.util.*;

public class Solution {
    private final Map<Character, Integer> targetMp = new HashMap<>();
    private final Map<Character, Integer> curMp = new HashMap<>();
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return "";
        for (char ch : t.toCharArray()) {
            targetMp.put(ch, targetMp.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int fL = -1, fR = -1;
        char[] chA = s.toCharArray();
        for (int right = 0; right < chA.length; right++) {
            char curCh = s.charAt(right);
            int occNum = curMp.getOrDefault(curCh, 0) + 1;
            curMp.put(curCh, occNum);
            if (occNum < targetMp.getOrDefault(curCh, 0) || targetMp.getOrDefault(curCh, 0) < 1) continue;
            while (isValidSubStr()) {
                int curLen = right-left+1;
                if (curLen < minLen) {
                    minLen = curLen;
                    fL = left;
                    fR = right;
                }
                int curChNum = curMp.getOrDefault(s.charAt(left), 0) - 1;
                curMp.put(s.charAt(left), curChNum);
                if (curChNum == 0) {
                    curMp.remove(s.charAt(left));
                }
                left += 1;
            }
        }
        return fL == -1 ? "" : s.substring(fL, fR+1);
    }

    private boolean isValidSubStr() {
        for (Map.Entry<Character, Integer> kv : targetMp.entrySet()) {
            Character ch = kv.getKey();
            Integer cnt = kv.getValue();
            Integer curCnt = curMp.getOrDefault(ch, 0);
            if (curCnt < cnt) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a";
        String t = "aa";
        String res = solution.minWindow(s, t);
        System.out.println(res);
    }
}
