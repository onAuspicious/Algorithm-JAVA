package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TreeAndQuery {

    static int n, r, q;
    static ArrayList<Integer>[] tree;
    static boolean[] check;
    static int[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] set = br.readLine().split(" ");
        n = Integer.parseInt(set[0]);
        r = Integer.parseInt(set[1]);
        q = Integer.parseInt(set[2]);
        tree = new ArrayList[n + 1];
        check = new boolean[n + 1];
        nodes = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            tree[a].add(b);
            tree[b].add(a);
        }

        check[r] = true;
        DFS(r);

        for (int i = 0; i < q; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(nodes[t]).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int node) {
        int cnt = 1;
        for (int i = 0; i < tree[node].size(); i++) {
            int now = tree[node].get(i);
            if (!check[now]) {
                check[now] = true;
                DFS(now);
                cnt += nodes[now];
            }
        }
        nodes[node] = cnt;
    }
}
