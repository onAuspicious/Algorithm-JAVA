package problems;

public class BestSet {

    public int[] solution(int n, int s) {
        int[] result = new int[n];
        if (n > s) {
            return new int[]{-1};
        } else {
            int val = s / n;
            for (int i = 0; i < n; i++) {
                result[i] = val;
            }
            for (int i = 0; i < s - (val * n); i++) {
                result[n - i - 1]++;
            }
        }
        return result;
    }
}
