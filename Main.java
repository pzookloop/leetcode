
import q3629.Solution;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {2,2,3,3};
        int res = main.minimumRefill(arr, 3, 4);
        System.out.println(res);
    }

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int left = 0, right = n-1;
        int orgCapA = capacityA, orgCapB = capacityB;
        int ans = 0;
        while (left <= right) {
            if (left == right) {
                int needWater = plants[left];
                if (capacityA >= capacityB) {
                    if (capacityA < needWater) {
                        ++ans;
                        capacityA = orgCapA - needWater;
                    } else {
                        capacityA -= needWater;
                    }
                } else {
                    if (capacityB < needWater) {
                        ++ans;
                        capacityB = orgCapB - needWater;
                    } else {
                        capacityB -= needWater;
                    }
                }
                ++left;
                --right;
            } else {
                int aNeedWater = plants[left];
                if (capacityA >= aNeedWater) {
                    capacityA -= aNeedWater;
                } else {
                    ++ans;
                    capacityA = orgCapA - aNeedWater;
                }
                int bNeedWater = plants[right];
                if (capacityB >= bNeedWater) {
                    capacityB -= bNeedWater;
                } else {
                    ++ans;
                    capacityB = orgCapB - bNeedWater;
                }
                ++left;
                --right;
            }
        }

        return ans;
    }
}
