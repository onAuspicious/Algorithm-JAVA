package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][2];
        int result = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(input[0]);
            list[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else if (o1[1] > o2[1]) {
                    return 1;
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int end = 0;

        for (int[] conf : list) {
            if (conf[0] >= end) {
                result++;
                end = conf[1];
            }
        }
        System.out.println(result);
    }
}
