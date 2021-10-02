package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TreeLength2 {

    static ArrayList<Node>[] tree;
    static boolean[] check;

    static class Node {
        int num;
        int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        // tree 의 index 에 모두 ArrayList<Node> 생성
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        // read 한 값을 tree에 넣어줌
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);
            tree[a].add(new Node(b, d));
            tree[b].add(new Node(a, d));
        }

        check = new boolean[n + 1];
        check[1] = true;
        DFS(1, 0);

        check = new boolean[n + 1];
        check[maxNow] = true;
        DFS(maxNow, 0);

        System.out.println(maxDistance);
    }

    static int maxDistance = 0;
    static int maxNow;

    static void DFS(int now, int distance) {
        if (distance > maxDistance) {
            maxDistance = distance;
            maxNow = now;
        }

        for (int i = 0; i < tree[now].size(); i++) {
            Node node = tree[now].get(i);
            if (!check[node.num]) {
                check[node.num] = true;
                DFS(node.num, distance + node.distance);
            }
        }
    }
}
