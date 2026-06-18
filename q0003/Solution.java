package q0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        Map<Character, Integer> mp = new HashMap<>();
        char[] chArr = s.toCharArray();
        for (int right = 0; right < chArr.length; right++) {
            char c = chArr[right];
            mp.put(c, mp.getOrDefault(c, 0) + 1);
            while (mp.getOrDefault(c, 0) > 1) {
                mp.put(chArr[left], mp.getOrDefault(chArr[left], 0)-1);
                left += 1;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
