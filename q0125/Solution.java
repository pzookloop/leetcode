package q0125;

public class Solution {
    public boolean isPalindrome(String s) {
        char[] sChArr = s.toCharArray();
        int l = 0, r = sChArr.length-1;
        while (l < r) {
            while (l<r && isInvalidChar(sChArr[l])) l++;
            while (l<r && isInvalidChar(sChArr[r])) r--;
            if (Character.toLowerCase(sChArr[l]) != Character.toLowerCase(sChArr[r])) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isInvalidChar(char c) {
        return !Character.isLetter(c) && !Character.isDigit(c);
    }
}
