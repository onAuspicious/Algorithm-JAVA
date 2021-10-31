package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class HidingPlay3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] check = new int[100001];
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(n);
        check[k] = Integer.MAX_VALUE;
        check[n] = 1;

        while (!dq.isEmpty()) {
            int now = dq.removeFirst();
            if (check[now] > check[k]) {
                continue;
            }
            if (now - 1 >= 0 && (check[now - 1] == 0 || check[now - 1] > check[now] + 1)) {
                check[now - 1] = check[now] + 1;
                dq.offerLast(now - 1);
            }
            if (now + 1 <= 100000 && (check[now + 1] == 0 || check[now + 1] > check[now] + 1)) {
                check[now + 1] = check[now] + 1;
                dq.offerLast(now + 1);
            }
            if (now * 2 <= 100000 && (check[now * 2] == 0 || check[now * 2] > check[now])) {
                check[now * 2] = check[now];
                dq.offerLast(now * 2);
            }
        }
        System.out.println(check[k]-1);
    }
}
