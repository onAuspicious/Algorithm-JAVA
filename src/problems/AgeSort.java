package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class AgeSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[][] list = new String[n][2];

        for (int i = 0; i < n; i++) {
            list[i] = br.readLine().split(" ");
        }

        Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
                    return 0;
                } else {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            }
        });

        for (String[] i : list) {
            sb.append(i[0]).append(" ").append(i[1]).append('\n');
        }
        System.out.println(sb);
    }
}
