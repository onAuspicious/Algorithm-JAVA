package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TreeLength {
    
    static HashMap<Integer, HashMap<Integer, Integer>> tree = new HashMap<>();
    static boolean[] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            tree.put(i, map);
        }

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            int cnt = 1;
            while (!input[cnt].equals("-1")) {
                int node = Integer.parseInt(input[cnt]);
                int distance = Integer.parseInt(input[cnt + 1]);
                HashMap<Integer, Integer> map = tree.get(Integer.parseInt(input[0]));
                map.put(node, distance);
                cnt += 2;
            }
        }

        int[] distances1 = new int[n + 1];
        int[] distances2 = new int[n + 1];
        int x = 0;
        int d = 0;

        check = new boolean[n + 1];
        check[1] = true;
        DFS(1, 0, distances1);

        for (int i = 0; i < n + 1; i++) {
            if (d < distances1[i]) {
                x = i; d = distances1[i];
            }
        }

        check = new boolean[n + 1];
        check[x] = true;
        DFS(x, 0, distances2);

        // 결과값을 찾고 출력
        int result = 0;
        for (int i = 0; i < n + 1; i++) {
            result = Math.max(result, distances2[i]);
        }
        System.out.println(result);
    }

    public static void DFS(int now, int distance, int[] distances) {
        for (Integer child : tree.get(now).keySet()) {
            if (!check[child]) {
                Integer d = tree.get(now).get(child);
                distances[child] = distance + d;
                check[child] = true;
                DFS(child, distance + d, distances);
            }
        }
    }

    public static void print() {
        for (Integer integer : tree.keySet()) {
            System.out.println("node: " + integer);
            for (Integer now : tree.get(integer).keySet()) {
                System.out.println(now + " " + tree.get(integer).get(now));
            }
        }
    }
}
