package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SectionSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int sum = 0;
        String[] input = br.readLine().split(" ");
        int[] sectionSum = new int[n+1];

        for (int i = 1; i < n + 1; i++) {
            sum += Integer.parseInt(input[i-1]);
            sectionSum[i] = sum;
        }

        for (int i = 0; i < m; i++) {
            String[] find = br.readLine().split(" ");
            sb.append(sectionSum[Integer.parseInt(find[1])] - sectionSum[Integer.parseInt(find[0]) - 1]).append('\n');
        }

        System.out.println(sb);
    }
}
