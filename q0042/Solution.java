package q0042;

public class Solution {
    public int trap(int[] height) {
        return m2(height);
    }

    private int m2(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int leftH = 0, rightH = 0;
        int l = 0, r = n-1;
        int area = 0;
        while (l <= r) {
            leftH = Math.max(leftH, height[l]);
            rightH = Math.max(rightH, height[r]);
            if (leftH < rightH) {
                area += leftH-height[l];
                l++;
            } else {
                area += rightH-height[r];
                r--;
            }
        }
        return area;
    }

    private int m1(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] preH = new int[n];
        preH[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            preH[i] = Math.max(height[i], preH[i-1]);
        }
        int[] postH = new int[n];
        postH[n-1] = height[n-1];
        for (int i = n-2; i >= 0; --i) {
            postH[i] = Math.max(height[i], postH[i+1]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int h = Math.min(preH[i], postH[i]);
            ans += h-height[i];
        }
        return ans;
    }
}
