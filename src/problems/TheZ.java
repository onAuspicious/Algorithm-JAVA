package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheZ {

    static int n, r, c;
    static int cur = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        Z(0, 0, (int) Math.pow(2, n) - 1, (int) Math.pow(2, n) - 1);
        System.out.println(result);
    }

    public static void Z(int row1, int col1, int row2, int col2) {
        if (row2 == row1 && col1 == col2) {
            if (row1 == r && col1 == c) {
                result = cur;
            }
            cur++;
            return;
        }
        int dif = (row2 - row1) / 2 + 1;
        if (row1 <= r && r <= row2 - dif && col1 <= c && c <= col2 - dif) {
            Z(row1, col1, row2 - dif, col2 - dif);
        } else cur += dif * dif;
        if (row1 <= r && r <= row2 - dif && col1 + dif <= c && c <= col2) {
            Z(row1, col1 + dif, row2 - dif, col2);
        } else cur += dif * dif;
        if (row1 + dif <= r && r <= row2 && col1 <= c && c <= col2 - dif) {
            Z(row1 + dif, col1, row2, col2 - dif);
        } else cur += dif * dif;
        if (row1 + dif <= r && r <= row2 && col1 <= c && c <= col2) {
            Z(row1 + dif, col1 + dif, row2, col2);
        } else cur += dif * dif;
    }
}
