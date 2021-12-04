package problems;

public class BallGame {

    public int solution(String[] drum) {
        int n = drum.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int row = 0;
            int col = i;
            int stars = 0;

            while (row < n && stars < 2) {
                char now = drum[row].charAt(col);
                if (now == '#') {
                    row++;
                } else if (now == '>') {
                    col++;
                } else if (now == '<') {
                    col--;
                } else {
                    stars++;
                    if (stars < 2) row++;
                }
            }

            if (row == n) {
                result++;
            }
        }

        return result;
    }
}
