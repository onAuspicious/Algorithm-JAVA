package problems;

public class NagudoGame {

    public int solution(int[][] board, int[][] skill) {
        for (int[] sk : skill) {
            // break
            if (sk[0] == 1) {
                for (int i = sk[1]; i < sk[3] + 1; i++) {
                    for (int j = sk[2]; j < sk[4] + 1; j++) {
                        board[i][j] -= sk[5];
                    }
                }
            } else { // recovery
                for (int i = sk[1]; i < sk[3] + 1; i++) {
                    for (int j = sk[2]; j < sk[4] + 1; j++) {
                        board[i][j] += sk[5];
                    }
                }
            }
        }

        int result = board.length * board[0].length;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] <= 0) {
                    result--;
                }
            }
        }
        return result;
    }
}
