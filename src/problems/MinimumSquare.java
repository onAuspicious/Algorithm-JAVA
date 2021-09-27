package problems;

public class MinimumSquare {

    public int solution(int[][] sizes) {
        int r = 0;
        int c = 0;

        for (int i = 0; i < sizes.length; i++) {
            r = Math.max(r, Math.min(sizes[i][0], sizes[i][1]));
            c = Math.max(c, Math.max(sizes[i][0], sizes[i][1]));
        }
        return r*c;
    }
}
