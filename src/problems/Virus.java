package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Virus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNum = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean[][] computers = new boolean[computerNum + 1][computerNum + 1];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            computers[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
            computers[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = true;
        }

        ArrayDeque<Integer> now = new ArrayDeque<>();
        boolean[] visitCheck = new boolean[computerNum + 1];
        int result = 0;
        int pop;

        now.add(1);
        visitCheck[1] = true;

        while (!now.isEmpty()) {
            pop = now.removeFirst();
            for (int i = 0; i < computerNum + 1; i++) {
                if (computers[pop][i] && !visitCheck[i]) {
                    now.add(i);
                    visitCheck[i] = true;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
