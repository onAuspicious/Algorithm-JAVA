package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree {

    static int[] tree = new int[10001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            tree[idx++] = Integer.parseInt(input);
        }
        postOrder(0, idx - 1);
        System.out.println(sb);
    }

    static void postOrder(int s, int e) {
        if (s > e) {
            return;
        }
        int mid = s + 1;
        while (mid <= e && tree[s] > tree[mid]) {
            mid++;
        }
        postOrder(s + 1, mid - 1);
        postOrder(mid, e);
        sb.append(tree[s]).append('\n');
    }
}
