import q3660.Q3660;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        Q3660 q3660 = new Q3660();
        int[] res = q3660.maxValue(nums);
        for (int re : res) {
            System.out.print(re + ",");
        }
        System.out.println();
    }
}
