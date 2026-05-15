package q1385;

import java.util.Arrays;

public class Solution {
//    绝对值函数$f(x) = |x - j| 在数轴上是 V 字型的,不是单调的,所以不能直接对绝对值的结果做二分
    // 比如j = 100, arr2[mid]=1000, arr2[mid-1]=95, d = 120, 按照二分逻辑忽略了95, 其实j是不合格的
    // 在二分查找中,mid 的移动必须基于明确的区间排除
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int j : arr1) {
            // |j-arr2[i]| <= d ==>
            // -d <= j-arr2[i] <= d ==>
            // -d + arr2[i] <= j <= d + arr2[i] ==>
            // 等式两边分别+/-d, 则arr2[i] <= j+d以及arr2[i]>=j-d ==> j-d<=arr2[i]<=j+d
            int left = 0, right = arr2.length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (arr2[mid] > j+d) {
                    right = mid-1;
                } else if (arr2[mid] < j-d) {
                    left = mid+1;
                } else {break;}
            }
            if (left > right) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {-803,715,-224,909,121,-296,872,807,715,407,94,-8,572,90,-520,-867,485,-918,-827,-728,-653,-659,865,102,-564,-452,554,-320,229,36,722,-478,-247,-307,-304,-767,-404,-519,776,933,236,596,954,464};
        int[] arr2 = {817,1,-723,187,128,577,-787,-344,-920,-168,-851,-222,773,614,-699,696,-744,-302,-766,259,203,601,896,-226,-844,168,126,-542,159,-833,950,-454,-253,824,-395,155,94,894,-766,-63,836,-433,-780,611,-907,695,-395,-975,256,373,-971,-813,-154,-765,691,812,617,-919,-616,-510,608,201,-138,-669,-764,-77,-658,394,-506,-675,523,730,-790,-109,865,975,-226,651,987,111,862,675,-398,126,-482,457,-24,-356,-795,-575,335,-350,-919,-945,-979,611};
        int d = 37;
        System.out.println(solution.findTheDistanceValue(arr1, arr2, d));
    }
}
