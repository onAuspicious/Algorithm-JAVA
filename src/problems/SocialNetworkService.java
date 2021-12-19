package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SocialNetworkService {

    static int[][] dp;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];
        tree = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            tree[a].add(b);
            tree[b].add(a);
        }

        dp(1, -1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
        br.close();
    }

    public static void dp(int now, int parent) {
        dp[now][0] = 0;
        dp[now][1] = 1;

        for (int child : tree[now]) {
            if (child == parent) continue;
            dp(child, now);
            dp[now][0] += dp[child][1];
            dp[now][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}