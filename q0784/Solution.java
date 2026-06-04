package q0784;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] chArr = s.toCharArray();
        dfsInput(chArr, ans, 0);
        return ans;
    }

    private void dfsInput(char[] chArr, List<String> ans, int i) {
        if (i == chArr.length) {
            ans.add(new String(chArr));
            return;
        }
        if (Character.isLetter(chArr[i])) {
            chArr[i] ^= 32;
            dfsInput(chArr, ans, i+1);
            chArr[i] ^= 32;
        }
        dfsInput(chArr, ans, i+1);
    }

    private void dfsOutput(char[] chArr, List<String> ans, int i) {
        ans.add(new String(chArr));
        if (i == chArr.length) {
            return;
        }
        for (int j = i; j < chArr.length; ++j) {
            if (Character.isLetter(chArr[j])) {
                chArr[j] ^= 32;
                dfsOutput(chArr, ans, j+1);
                chArr[j] ^= 32;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "a1b2";
        System.out.println(s.letterCasePermutation(str));
    }
}
