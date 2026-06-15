package q00lcp51;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int ans = -1;
    private int curTastySum = 0;
    private int curSatietySum = 0;
    private int n = 0;
    private int limit = 0;
    private static final Map<Integer, Integer> tastyMp = new HashMap<>();
    private static final Map<Integer, Integer> satietyMp = new HashMap<>();
    public int perfectMenu(int[] materials, int[][] cookbooks,
                           int[][] attribute, int limit) {
        this.n = cookbooks.length;
        this.limit = limit;
        for (int i = 0; i < attribute.length; i++) {
            int[] cuisine = attribute[i];
            tastyMp.put(i, cuisine[0]);
            satietyMp.put(i, cuisine[1]);
        }
        dfsInput(materials, cookbooks, attribute, 0);
        return ans;
    }

    private void dfsInput(int[] materials, int[][] cookbooks, int[][] attribute, int i) {
        if (i == n) {
            if (curSatietySum >= limit) {
                ans = Math.max(ans, curTastySum);
            }
            return;
        };
        dfsInput(materials, cookbooks, attribute, i+1);
        if (canMake(materials, cookbooks[i])) {
            curTastySum += attribute[i][0];
            curSatietySum += attribute[i][1];
            calRemindMaterial(materials, cookbooks[i], -1);
            dfsInput(materials, cookbooks, attribute, i+1);
            calRemindMaterial(materials, cookbooks[i], 1);
            curTastySum -= attribute[i][0];
            curSatietySum -= attribute[i][1];
        }
    }

    private void calRemindMaterial(int[] materials, int[] cookbook, int coe) {
        for (int i = 0; i < materials.length; i++) {
            materials[i] += coe * cookbook[i];
        }
    }

    private boolean canMake(int[] materials, int[] cookbook) {
        for (int i = 0; i < materials.length; i++) {
            if (materials[i] < cookbook[i]) return false;
        }
        return true;
    }

    private void dfsOutput(int[] materials, int[][] cookbooks, int[][] attribute, int i) {
        if (curSatietySum >= limit) {
            ans = Math.max(ans, curTastySum);
        }
        if (i >= n) {
            return;
        }
        for (int j = i; j < n; j++) {
            int[] cookbook = cookbooks[j];
            if (canMake(materials, cookbook)) {
                curTastySum += attribute[j][0];
                curSatietySum += attribute[j][1];
                calRemindMaterial(materials, cookbook, -1);
                dfsOutput(materials, cookbooks, attribute, j+1);
                calRemindMaterial(materials, cookbook, 1);
                curTastySum -= attribute[j][0];
                curSatietySum -= attribute[j][1];
            }
        }
    }
}
