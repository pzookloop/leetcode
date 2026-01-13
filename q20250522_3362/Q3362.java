package q20250522_3362;

public class Q3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        // o(n)找到最大的值索引+值
        int[] maxIndexValue = findMax(nums);
        return 0;
    }

    private int[] findMax(int[] nums) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= res[1]){
                res[0] = i;
                res[1] = nums[i];
            }
        }

        return res;
    }
}
