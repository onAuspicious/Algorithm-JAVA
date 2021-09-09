package problems;

public class WalkerHeaven {

    static int[][][] check_map;

    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        if (m == 1 || n == 1) {
            return 1;
        }
        check_map = new int[m][n][2];
        check_map[0][0][0] = 1;
        if (cityMap[1][0] != 1) {
            check_map[1][0][1] = 1;
        }

        // top
        for (int i = 0; i < m; i++) {
            if (i > 1 && cityMap[i][0] != 1) {
                check_map[i][0][1] = check_map[i-1][0][1];
            }
            for (int j = 1; j < n; j++) {
                if (i == 0 && cityMap[0][j] != 1) {
                    check_map[0][j][0] = check_map[0][j - 1][0];
                    continue;
                }
                if (cityMap[i][j] == 1) {
                    continue;
                }
                if (cityMap[i][j - 1] == 2) {
                    check_map[i][j][0] = check_map[i][j - 1][0];
                } else {
                    check_map[i][j][0] = (check_map[i][j - 1][0] + check_map[i][j - 1][1]) % MOD;
                }
                if (cityMap[i - 1][j] == 2) {
                    check_map[i][j][1] = check_map[i - 1][j][1];
                } else {
                    check_map[i][j][1] = (check_map[i - 1][j][0] + check_map[i - 1][j][1]) % MOD;
                }
            }
        }
        return (check_map[m - 1][n - 1][0] + check_map[m - 1][n - 1][1]) % MOD;
    }
}
