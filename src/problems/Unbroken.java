package problems;

public class Unbroken {

    public int solution(int[][] board, int[][] skill) {
        int r = board.length;
        int c = board[0].length;
        int[][] save = new int[r + 1][c + 1]; // 누적 합 저장
        int result = 0; // 반환 될 결과값 저장

        // 누적합을 담은 save 배열의 point 를 지정
        for (int[] s : skill) {
            pointing(save, s[1], s[2], s[3], s[4], (s[0] == 1) ? -s[5] : s[5]);
        }

        // 위에서 아래로 누적합 구해주기
        for (int i = 0; i < c; i++) {
            for (int j = 1; j < r; j++) {
                save[j][i] += save[j - 1][i];
            }
        }

        // 왼쪽에서 오른쪽으로 누적합 구해주기
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                save[i][j] += save[i][j - 1];
            }
        }

        // 결과 구하기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] + save[i][j] <= 0) {
                    result++;
                }
            }
        }

        return result;
    }

    public void pointing(int[][] save, int r1, int c1, int r2, int c2, int val) {
        save[r1][c1] = val;
        save[r1][c2 + 1] = -val;
        save[r2 + 1][c1] = -val;
        save[r2][c2] = val;
    }
}
