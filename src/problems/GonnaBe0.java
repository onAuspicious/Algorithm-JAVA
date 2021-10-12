package problems;

import java.util.*;

public class GonnaBe0 {

    static long result = 0;

    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        long tmp = 0;
        long[] arr = new long[n];;
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            tmp += a[i];
            arr[i] = a[i];
        }

        if (tmp != 0) return -1L;

        // tree init
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }

        check[0] = true;
        DFS(0, arr, tree, check);

        return result;
    }

    static void DFS(int now, long[] a, ArrayList<Integer>[] tree, boolean[] check) {
        for (int next : tree[now]) {
            if (!check[next]) {
                check[next] = true;
                DFS(next, a, tree, check);
                a[now] += a[next];
                result += Math.abs(a[next]);
            }
        }
    }
}
