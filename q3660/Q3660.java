package q3660;

public class Q3660 {
    public int[] maxValue(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return new int[] {nums[0]};
        }

        int[] res = new int[length];

        int maxVal = Integer.MIN_VALUE;
        int[] dpLeftMax = new int[length];
        dpLeftMax[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dpLeftMax[i] = Math.max(dpLeftMax[i - 1], nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }

        // 从右向左看, 最右侧的第一个元素永远能取到以他为起点向左最大的元素.i+1是i右侧的数字, 通过跳转到右侧最小的数字位置, 再跳到i+1, 所以i+1能取到最大的数字也是i能取到的最大的数字.
        // 1. 右侧第一个位置永远能跳到最大的数字
        int rightMin = Integer.MAX_VALUE;
        for (int i = length-1; i >= 0; i--) {
            res[i] = dpLeftMax[i] > rightMin ? res[i+1] : dpLeftMax[i];
            rightMin = Math.min(rightMin, nums[i]);
        }


        return res;
    }
}
