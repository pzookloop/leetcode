package q0970;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < 21; ++i) {
            if (Math.pow(x, i) > bound) break;
            for (int j = 0; j < 21; ++j) {
                if (Math.pow(y, j) > bound) break;
                double result = Math.pow(x, i) + Math.pow(y, j);
                if (result > bound) break;
                resultSet.add((int) result);
            }
        }

        return new ArrayList<>(resultSet);
    }
}
