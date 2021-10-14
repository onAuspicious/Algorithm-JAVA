package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberRectangle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int result = 1;
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int size = 1;
                while (i + size < n && j + size < m) {
                    int now = arr[i][j];
                    if (arr[i][j + size] == now && arr[i + size][j] == now && arr[i + size][j + size] == now) {
                        result = Math.max(result, (size + 1) * (size + 1));
                    }
                    size++;
                }
            }
        }
        System.out.println(result);
    }
}
