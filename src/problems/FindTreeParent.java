package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class FindTreeParent {

    static ArrayList<Integer>[] list;
    static boolean[] check;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int now) {
        for (int i = 0; i < list[now].size(); i++) {
            int tmp = list[now].get(i);
            if (!check[tmp]) {
                check[tmp] = true;
                parent[tmp] = now;
                DFS(tmp);
            }
        }
    }

    public static void solutionBFS() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(1);

        while (!dq.isEmpty()) {
            int now = dq.pollFirst();
            for (int i = 0; i < list[now].size(); i++) {
                int child = list[now].get(i);
                if (!check[child]) {
                    check[child] = true;
                    parent[child] = now;
                    dq.add(child);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        check = new boolean[n + 1];
        check[1] = true;
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list[a].add(b);
            list[b].add(a);
        }

        solutionBFS();

//        DFS(1);

        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }
}
