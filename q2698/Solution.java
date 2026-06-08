package q2698;

public class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if(check(i)) {
                res += i * i;
            }

        }
        return res;
    }

    private boolean check(int num) {
        String numStr = String.valueOf(num * num);
        return dfsInput(numStr, 0, 0, num);
//        return dfsOutput(numStr, 0, num);
    }

    private boolean dfsOutput(String str, int i, int target) {
        if (i == str.length()) {
            return target == 0;
        }
        int num = 0;
        for (int j = i; j < str.length(); j++) {
            num = num * 10 + (str.charAt(j) - '0');
            if (num > target) break;
            if (dfsOutput(str, j+1, target-num)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsInput(String str, int i, int start, int target) {
        if (i == str.length()) {
            return target == 0;
        }
        boolean merge = false;
        if (i < str.length()-1) {
            merge = dfsInput(str, i + 1, start, target);
        }
        int num = Integer.parseInt(str.substring(start, i+1));
        if (num > target) return merge;
        return merge || dfsInput(str, i+1, i+1, target-num);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 91;
        System.out.println(s.punishmentNumber(n));
    }
}
