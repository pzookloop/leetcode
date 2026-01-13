import q1289.Q1289;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int i = 1, j = 3;

        int[] diff = new int[a.length + 1];

        // 差分数组加1操作
        diff[i] += 1;
        diff[j + 1] -= 1;

        // 应用差分数组到原数组
        int sum = 0;
        for (int k = 0; k < a.length; k++) {
            sum += diff[k];
            a[k] += sum;
        }

        // 输出结果
        for (int num : a) {
            System.out.print(num + " ");
        }
    }


    private int[] diffArray(int i, int j, int n) {
        int[] diff = new int[n+1];
        assert i >= 0;
        assert j + 1 < n;
        diff[i] += 1;
        diff[j + 1] -= 1;
        return diff;
    }
}
