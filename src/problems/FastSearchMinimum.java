package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class FastSearchMinimum {

    static int[] res;
    static int[] result;

    static void solution(int l) {
        Deque<int[]> list = new ArrayDeque<>();
        for (int i = 0; i < res.length; i++) {
            if (!list.isEmpty()) {
                if (list.getFirst()[1] == i) {
                    list.removeFirst();
                }
                while (!list.isEmpty()) {
                    if (list.getLast()[0] >= res[i]) {
                        list.removeLast();
                    } else {
                        break;
                    }
                }
            }
            list.add(new int[]{res[i], i + l});
            result[i] = list.getFirst()[0];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        res = new int[n];
        result = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = Integer.parseInt(line[i]);
        }

        solution(l);

        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
