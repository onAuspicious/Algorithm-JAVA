package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sticker {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int tests = Integer.parseInt(br.readLine());

        for (int i = 0; i < tests; i++) {
            sb.append(solution(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.println(sb);
    }

    static int solution(int n) throws IOException {
        int[][] stickers = new int[2][n];
        for (int i = 0; i < 2; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                stickers[i][j] = Integer.parseInt(input[j]);
            }
        }

        if (n == 1) {
            return Math.max(stickers[1][0], stickers[0][0]);
        }
        stickers[0][1] += stickers[1][0];
        stickers[1][1] += stickers[0][0];
        int result = Math.max(stickers[0][1], stickers[1][1]);

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                // ll, lld, ld
                if (j == 0) {
                    stickers[j][i] += Math.max(stickers[j][i - 2], Math.max(stickers[j + 1][i - 1], stickers[j + 1][i - 2]));
                } else {
                    stickers[j][i] += Math.max(stickers[j][i - 2], Math.max(stickers[j - 1][i - 1], stickers[j - 1][i - 2]));
                }
                result = Math.max(stickers[j][i], result);
            }
        }

        return result;
    }
}
