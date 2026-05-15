package q2080;

import java.util.*;

public class RangeFreqQuery {
    private final Map<Integer, List<Integer>> mp = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.mp.computeIfAbsent(arr[i], _ -> new ArrayList<>()).add(i);
        }
    }
    public int query(int left, int right, int value) {
        List<Integer> ids = this.mp.getOrDefault(value, new ArrayList<>());
        if (ids.isEmpty()) return 0;
        int p = low_bound(ids, left);
        int q = low_bound(ids, right+1);
        return q-p;
    }
    private int low_bound(List<Integer> subArr, int value) {
        int left = 0, right = subArr.size()-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (subArr.get(mid) < value) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
