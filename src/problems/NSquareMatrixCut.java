package problems;

public class NSquareMatrixCut {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int)(right - left) + 1];
        int i = 0;
        while (left <= right) {
            int startVal = (int)(left / n) + 1;
            int now = (int)(left % n) + 1;
            result[i] = Math.max(startVal, now);
            i++;
            left++;
        }

        return result;
    }
}
