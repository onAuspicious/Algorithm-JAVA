package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lamp {

    static int n, m, k;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int[][] graph = new int[n][m];

        // init graph
        for (int i = 0; i < n; i++) {
            String g = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = g.charAt(j) - '0';
            }
        }
        k = Integer.parseInt(br.readLine());

        // 열 단위로 몇 개의 구멍이 있는지 판단 후 같은 배열 찾기
        for (int i = 0; i < n; i++) {
            // count 0 lamps
            int blankCount = 0;
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) blankCount++;
            }

            if (blankCount % 2 == k % 2 && blankCount <= k) {
                int equalRowCnt = 0;
                boolean endPoint;
                for (int j = 0; j < n; j++) {
                    endPoint = true;
                    for (int l = 0; l < m; l++) {
                        if (graph[j][l] != graph[i][l]) {
                            endPoint = false;
                            break;
                        }
                    }
                    if (endPoint) equalRowCnt++;
                }
                result = Math.max(result, equalRowCnt);
            }
        }

        System.out.println(result);
    }
}
