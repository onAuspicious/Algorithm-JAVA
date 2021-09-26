package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindWay {

    static int max = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int input = Integer.parseInt(br.readLine());
        int[][] graph = new int[input][input];

        for (int i = 0; i < input; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < input; j++) {
                if (Integer.parseInt(line[j]) == 0) {
                    graph[i][j] = max;
                } else {
                    graph[i][j] = 1;
                }
            }
        }

        // f-y
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                for (int k = 0; k < input; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (graph[i][j] != max) {
                    stringBuilder.append(1).append(" ");
                } else {
                    stringBuilder.append(0).append(" ");
                }
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
    }
}
