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


//        int[] diff = new int[128]; // 窗口每种字母个数 - t 每种字母个数
//        int kinds = 0;
//        for (char c : t.toCharArray()) {
//            if (diff[c] == 0) {
//                kinds++; // 统计 t 有多少个不同的字母
//            }
//            diff[c]--;
//        }
//
//        char[] s = S.toCharArray();
//        int m = s.length;
//        int ansLeft = -1;
//        int ansRight = m;
//        int geCnt = 0; // 窗口内有 geCnt 种字母的出现次数 >= t 中相应字母的出现次数
//        int left = 0;
//
//        for (int right = 0; right < m; right++) { // 移动子串右端点
//            char c = s[right]; // 右端点字母
//            diff[c]++; // 右端点字母移入子串
//            if (diff[c] == 0) { // 原来窗口内 c 的出现次数比 t 的少，现在一样多
//                geCnt++; // 从 < 变成 >=
//            }
//
//            while (geCnt == kinds) { // 涵盖：所有字母的出现次数都是 >=
//                if (right - left < ansRight - ansLeft) { // 找到更短的子串
//                    ansLeft = left; // 记录此时的左右端点
//                    ansRight = right;
//                }
//
//                char x = s[left]; // 左端点字母
//                if (diff[x] == 0) {
//                    // x 移出窗口之前，检查出现次数，
//                    // 如果窗口内 x 的出现次数和 t 一样，
//                    // 那么 x 移出窗口后，窗口内 x 的出现次数比 t 的少
//                    geCnt--; // 从 >= 变成 <
//                }
//                diff[x]--; // 左端点字母移出子串
//                left++;
//            }
//        }
//
//        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
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
