package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class LetsGoTravel {

    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int load = Integer.parseInt(input[j - 1]);
                if (load == 1) graph[i].add(j);
            }
        }

        String[] input = br.readLine().split(" ");
        route = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            route[i] = Integer.parseInt(input[i]);
        }

        boolean result = true;

        for (int i = 0; i < route.length - 1; i++) {
            int start = route[i];
            int end = route[i + 1];
            if (start == end) continue;
            if (!isConnected(start, end)) {
                result = false;
                break;
            }
        }

        System.out.println(result ? "YES" : "NO");
        br.close();
    }

    public static boolean isConnected(int start, int end) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        boolean[] visit = new boolean[n + 1];

        dq.offerLast(start);

        while (!dq.isEmpty()) {
            Integer now = dq.removeFirst();

            for (int next : graph[now]) {
                if (!visit[next]) {
                    dq.offerLast(next);
                    visit[next] = true;
                }
                if (next == end) {
                    return true;
                }
            }
        }
        return false;
    }
}
