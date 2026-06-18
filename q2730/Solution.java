package q2730;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 0;
        int l = 0;
        Map<String, Integer> m = new HashMap<>();
        char[] ca = s.toCharArray();
        for (int r = 0; r < ca.length; r++) {
            if (r == 0) {
                ans = 1;
                continue;
            }
            if (ca[r] == ca[r-1]) {
                String pre = "" + ca[r] + ca[r-1];
                m.put(pre, m.getOrDefault(pre, 0)+1);
                while (m.size() > 1 || m.getOrDefault(pre, 0) > 1) {
                    String p =  "" + ca[l] + ca[l+1];
                    Integer rem = m.getOrDefault(p, 0);
                    if (rem > 0) {
                        rem -= 1;
                        if (rem == 0) {
                            m.remove(p);
                        } else {
                            m.put(p, rem);
                        }
                    }
                    l += 1;
                }
            }
            ans = Math.max(ans, r-l+1);
        }
        // 111
        return ans;
    }

    public static void main(String[] args) {
        String[] ss = {"52233", "5494", "1111111"};
        Solution s = new Solution();
        for (String str : ss) {
            System.out.println(s.longestSemiRepetitiveSubstring(str));
        }
    }
}
