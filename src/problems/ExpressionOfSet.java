package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpressionOfSet {

    static int n, m;
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);  // n + 1
        m = Integer.parseInt(input[1]);  // m 개의 연산
        set = new int[n + 1];

        // 자기 자신을 부모로 가짐
        for (int i = 0; i < n + 1; i++) {
            set[i] = i;
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int f = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            if (f == 0) {
                union(a, b);
            } else if (f == 1) {
                sb.append(isSame(a, b) ? "YES" : "NO").append('\n');
            }
        }
        System.out.println(sb);
    }

    // a가 포함되어 있는 집합과 b가 포함되어 있는 집합을 합친다.
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                set[b] = a;
            } else {
                set[a] = b;
            }
        }
    }

    public static int find(int a) {
        if (a == set[a]) {
            return a;
        }
        // point
        return set[a] = find(set[a]);
    }

    public static boolean isSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
}
