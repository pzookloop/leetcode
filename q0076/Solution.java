package q0076;

import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMp = new HashMap<>();
        Set<Character> tSet = new HashSet<>();
        for (char ch : t.toCharArray()) {
            tMp.put(ch, tMp.getOrDefault(ch, 0) + 1);
            tSet.add(ch);
        }
        int minWinCnt = Integer.MAX_VALUE;
        int left = 0, ansLeft = -1, ansRight = -1;
        char[] sChArr = s.toCharArray();
        Map<Character, Integer> sMp = new HashMap<>();
        Set<Character> sSet = new HashSet<>();
        for (int right = 0; right < sChArr.length; right++) {
            sMp.put(sChArr[right], sMp.getOrDefault(sChArr[right], 0) + 1);
            sSet.add(sChArr[right]);
            while (isQualify(sMp, tMp, sSet, tSet)) {
                if (minWinCnt > right-left+1) {
                    minWinCnt = right-left+1;
                    ansLeft = left;
                    ansRight = right;
                }
                char ch = sChArr[left];
                sMp.put(ch, sMp.getOrDefault(ch, 0)-1);
                if (sMp.getOrDefault(ch, 0) < 1) {
                    sSet.remove(ch);
                }
                left++;
            }
        }

        StringBuilder ansStr = new StringBuilder();
        if (ansLeft != -1) {
            for (int i = ansLeft; i <= ansRight; i++) {
                ansStr.append(sChArr[i]);
            }
        }
        return ansStr.toString();
    }

    private boolean isQualify(Map<Character, Integer> sMp, Map<Character, Integer> tMp, Set<Character> sSt, Set<Character> tSt) {
        boolean res = true;
        if (sSt.containsAll(tSt)) {
            for (Character ch : tSt) {
                res &= sMp.getOrDefault(ch, 0) >= tMp.getOrDefault(ch, 0);
            }
        } else {
            res = false;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a";
        String t = "aa";
        String res = solution.minWindow(s, t);
        System.out.println(res);
    }
}
