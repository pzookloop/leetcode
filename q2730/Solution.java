package q2730;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        if (s.length() < 3) return s.length();
        char[] chArr = s.toCharArray();
        Map<String, Integer> mp = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int right = 0; right < chArr.length; right++) {
            if (right == 0) {
                ans += 1;
                continue;
            }
            if (chArr[right-1] == chArr[right]) {
                String str = "" + chArr[right - 1] + chArr[right];
                mp.put(str, mp.getOrDefault(str, 0) + 1);
                if (mp.size() > 1 || mp.getOrDefault(str, 0) > 1) {
                    while (left+1 < right &&
                            (mp.size() > 1 || mp.getOrDefault(str, 0) > 1)) {
                        String lStr = "" + chArr[left] + chArr[left + 1];
                        Integer rem = mp.getOrDefault(lStr, 0);
                        if (rem > 0) {
                            rem -= 1;
                            mp.put(lStr, rem);
                            if (rem == 0) {
                                mp.remove(lStr);
                            }
                        }
                        left +=1;
                    }
                }
            }
            ans = Math.max(ans, right-left+1);
        }

        return ans;


//        char[] s = S.toCharArray();
//        int ans = 1;
//        int same = 0;
//        int left = 0;
//        for (int right = 1; right < s.length; right++) {
//            if (s[right] == s[right - 1]) {
//                same++;
//            }
//            if (same > 1) { // same == 2
//                left++;
//                while (s[left] != s[left - 1]) {
//                    left++;
//                }
//                same = 1;
//            }
//            ans = Math.max(ans, right - left + 1);
//        }
//        return ans;
    }
}
