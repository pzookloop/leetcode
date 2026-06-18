package q2105;

public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int l = 0, r = plants.length-1;
        int curCa = capacityA, curCb = capacityB;
        while (l < r) {
            if (curCa >= plants[l]) {
                curCa -= plants[l];
            } else {
                ans += 1;
                curCa = capacityA - plants[l];
            }
            l++;
            if (curCb >= plants[r]) {
                curCb -= plants[r];
            } else {
                ans += 1;
                curCb = capacityB-plants[r];
            }
            r--;
        }
        if (l == r && Math.max(curCa, curCb) < plants[l]) {
            ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] p = {1,2,4,4,5};
        int ca = 6, cb= 5;
        Solution s = new Solution();
        System.out.println(s.minimumRefill(p, ca, cb));
    }
}
