package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConnectCount {

    static int n, m;
    static ArrayList<Integer>[] tree;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int result = 0;
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        tree = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            tree[a].add(b);
            tree[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int now) {
        for (int next : tree[now]) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next);
            }
        }
    }
}
