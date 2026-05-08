package q3629;

import java.util.*;

public class Solution {
    private static final int MX = 1_000_001;
    private static final List<Integer>[] primeFactors = new ArrayList[MX];
    private static boolean initialized = false;

    // 这样写比 static block 更快
    public Solution() {
        if (initialized) {
            return;
        }
        initialized = true;

        Arrays.setAll(primeFactors, _ -> new ArrayList<>());

        for (int i = 2; i < MX; ++i) {
            if (primeFactors[i].isEmpty()) {
                for (int j = i; j < MX; j += i) {
                    primeFactors[j].add(i);
                }
            }
        }

    }

    public int minJumps(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> group = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> primeFactor = primeFactors[nums[i]];
            for (Integer pf : primeFactor) {
                group.computeIfAbsent(pf, _ -> new ArrayList<>()).add(i);
            }
        }

        boolean[] vis = new boolean[n];
        vis[0] = true;
        List<Integer> queue = List.of(0);

        for (int ans = 0; ; ++ans) {
            List<Integer> tmp = queue;
            queue = new ArrayList<>();
            for (Integer currentStep : tmp) {
                if (currentStep == n-1) {
                    return ans;
                }
                List<Integer> primeFactorNb = group.computeIfAbsent(nums[currentStep], _ -> new ArrayList<>());
                primeFactorNb.add(currentStep + 1);
                if (currentStep > 0) {
                    primeFactorNb.add(currentStep - 1);
                }

                for (Integer pb : primeFactorNb) {
                    if (!vis[pb]) {
                        vis[pb] = true;
                        queue.add(pb);
                    }
                }

                primeFactorNb.clear();
            }
        }

    }
}
