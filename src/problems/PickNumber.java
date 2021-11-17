package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class PickNumber {

    static int n;
    static int[] info;
    static boolean[] visit;
    static HashSet<Integer> connectSet = new HashSet<>();
    static boolean connected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> result = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        info = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(br.readLine()) - 1;
        }

        for (int i = 0; i < n; i++) {
            connected = false;
            if (!visit[i]) {
                findSet(info[i], i);
                connectSet.add(info[i]);
                if (connected) {
                    connectSet.add(i);
                    for (Integer key : connectSet) {
                        result.add(key);
                        visit[key] = true;
                    }
                }
                connectSet.clear();
            } else {
                visit[i] = true;
            }
        }

        Collections.sort(result);

        sb.append(result.size()).append('\n');
        for (Integer i : result) {
            sb.append(i + 1).append('\n');
        }
        System.out.println(sb);
    }

    public static void findSet(int cur, int goal) {
        if (cur == goal) {
            connected = true;
            return;
        }
        if (!connectSet.contains(info[cur]) && !visit[info[cur]]) {
            connectSet.add(info[cur]);
            findSet(info[cur], goal);
        }
    }
}
