package q2861;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    // n种金属, k台机器 stock每种金属的储备 cost每种金属的花销 1 <= n,k <= 100
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        // 某台机器生产合金只会用到开销最小的金属, 开销为1, 预算为10^8, 库存为10^8, 此时能生产的合金数量上限: (long) 2e8
        int ans = 0;
        for (List<Integer> machine : composition) {
            int left = 0, right = Collections.min(stock) + budget;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (calculateCost(machine, mid, stock, cost, budget)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } // max <= budget ==> max < b+1 ==> min >= b+1
            ans = Math.max(ans, (int) (left - 1));
//            System.out.println("使用第:" + i + "台机器生产合金数量: " + (left-1));
        }

        return ans;
    }

    private boolean calculateCost(List<Integer> machine, long metalCnt, List<Integer> stock, List<Integer> cost, long budget) {
        for (int i = 0; i < machine.size(); i++) {
            long needKm = Math.max(0, (long) machine.get(i) * metalCnt - stock.get(i));
            if (needKm * cost.get(i) > budget) {
                return false;
            }
            budget -= needKm * cost.get(i);
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 1, k = 7, budget = 48;
        List<List<Integer>> composition = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(3)),
                new ArrayList<>(Arrays.asList(4)),
                new ArrayList<>(Arrays.asList(5)),
                new ArrayList<>(Arrays.asList(6)),
                new ArrayList<>(Arrays.asList(7))
        ));
        List<Integer> stock = new ArrayList<>(Arrays.asList(6));
        List<Integer> cost = new ArrayList<>(Arrays.asList(1));

        int result = solution.maxNumberOfAlloys(n, k, budget, composition, stock, cost);
        System.out.println(result);
    }
}
