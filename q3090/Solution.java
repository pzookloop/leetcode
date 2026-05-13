package q3090;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        if (n < 3) return n;
        int ans = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chArr = s.toCharArray();
        for (int right = 0; right < chArr.length; right++) {
            map.put(
                    chArr[right],
                    map.getOrDefault(chArr[right],0) + 1);
            while (map.getOrDefault(chArr[right], 0) > 2) {
                map.put(
                        chArr[left],
                        map.getOrDefault(chArr[left],0) - 1);
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}
