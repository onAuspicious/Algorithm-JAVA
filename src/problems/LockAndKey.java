package problems;

public class LockAndKey {
    static int lSize;
    static int kSize;
    public boolean solution(int[][] key, int[][] lock) {
        lSize = lock.length;
        kSize = key.length;
        int[][] board = new int[lSize + (kSize - 1) * 2][lSize + (kSize - 1) * 2];

        // board 에 lock 이식
        for (int i = 0; i < lSize; i++) {
            for (int j = 0; j < lSize; j++) {
                board[i + kSize - 1][j + kSize - 1] = lock[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < kSize + lSize - 1; j++) {
                for (int k = 0; k < kSize + lSize - 1; k++) {
                    if (check(key, board, j, k, kSize-1, kSize-1)) return true;
                }
            }
            key = move(key);
        }
        return false;
    }

    public static boolean check (int[][] key, int[][] board, int x, int y, int fx, int fy) {
        boolean state = true;
        // key +
        for (int i = 0; i < kSize; i++) {
            for (int j = 0; j < kSize; j++) {
                board[i + x][j + y] += key[i][j];
            }
        }
        // find
        for (int i = 0; i < lSize; i++) {
            for (int j = 0; j < lSize; j++) {
                if (board[i + fx][j + fy] != 1) {
                    state = false;
                    break;
                }
            }
            if (!state) break;
        }
        // key -
        for (int i = 0; i < kSize; i++) {
            for (int j = 0; j < kSize; j++) {
                board[i + x][j + y] -= key[i][j];
            }
        }
        return state;
    }

    public static int[][] move (int[][] key) {
        int[][] change = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = key.length - 1; j >= 0; j--) {
                change[key.length - j - 1][i] = key[i][j];
            }
        }
        return change;
    }
}
