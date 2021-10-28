package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Lie {

    static int n, m;
    static boolean[] knowCheck;
    static int[][] graph;
    static HashMap<Integer, int[]> parties = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        knowCheck = new boolean[n + 1];
        graph = new int[n + 1][n + 1];
        String[] knows = br.readLine().split(" ");
        if (knows[0].equals("0")) {
            System.out.println(m);
            System.exit(0);
        }

        for (int i = 1; i < knows.length; i++) {
            int k = Integer.parseInt(knows[i]);
            knowCheck[k] = true;
            dq.offerLast(k);
        }

        for (int i = 0; i < m; i++) {
            String[] party = br.readLine().split(" ");
            int[] toInt = new int[party.length - 1];
            for (int j = 1; j < party.length; j++) {
                toInt[j - 1] = Integer.parseInt(party[j]);
            }
            parties.put(i, toInt);
            for (int j : toInt) {
                for (int k : toInt) {
                    graph[j][k] = 1;
                }
            }
        }

        while (!dq.isEmpty()) {
            Integer now = dq.removeFirst();
            for (int i = 1; i <= n; i++) {
                if (!knowCheck[i] && graph[now][i] == 1) {
                    knowCheck[i] = true;
                    dq.offerLast(i);
                }
            }
        }

        int result = 0;

        for (Integer party : parties.keySet()) {
            boolean state = true;
            for (int i : parties.get(party)) {
                if (knowCheck[i]) {
                    state = false;
                    break;
                }
            }
            if (state) {
                result++;
            }
        }
        System.out.println(result);
    }
}
