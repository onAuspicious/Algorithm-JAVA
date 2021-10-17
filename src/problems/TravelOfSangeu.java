package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TravelOfSangeu {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // test case num

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]); // 국가의 수
            int m = Integer.parseInt(split[1]); // 비행기 경로 수
            ArrayList<Integer>[] tree = new ArrayList[n + 1];
            // tree init
            for (int j = 0; j < n + 1; j++) {
                tree[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                tree[a].add(b);
                tree[b].add(a);
            }
            sb.append(n - 1).append('\n');
        }
        System.out.println(sb);
    }
}
