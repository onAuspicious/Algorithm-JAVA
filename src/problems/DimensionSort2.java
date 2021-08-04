package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DimensionSort2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(line[0]);
            list[i][1] = Integer.parseInt(line[1]);
        }
        Arrays.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int[] i : list) {
            sb.append(i[0]).append(" ").append(i[1]).append('\n');
        }
        System.out.println(sb);
    }
}
