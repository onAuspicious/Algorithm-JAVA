package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bulk {

    public int[] solution(int[][] list) {
        int[] result = new int[list.length];
        int cnt;

        for (int i = 0; i < list.length; i++) {
            cnt = 1;
            for (int j = 0; j < list.length; j++) {
                if (list[i][0] < list[j][0] && list[i][1] < list[j][1]) {
                    cnt++;
                }
            }
            result[i] = cnt;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Bulk bulk = new Bulk();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            list[i] = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])};
        }
        int[] solution = bulk.solution(list);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
