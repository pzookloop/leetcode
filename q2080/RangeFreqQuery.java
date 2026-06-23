package q2080;

import java.util.*;

public class RangeFreqQuery {
    private final Map<Integer, List<Integer>> mp = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            mp.computeIfAbsent(arr[i], _ -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> range = mp.getOrDefault(value, new ArrayList<>());
        if (range.isEmpty() || range.getFirst() > right || range.getLast() < left) return 0;
        int lb = lowBound(range, left);
        int rb = lowBound(range, right+1);
        return rb-lb;
    }

    private int lowBound(List<Integer> range, int target) {
        int left = 0, right = range.size()-1;
        while (left<=right) {
            int mid = (left + right) >>> 1;
            if (range.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
