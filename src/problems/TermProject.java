package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TermProject {

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] students = new int[n];
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                students[j] = Integer.parseInt(input[j]) - 1;
            }
            sb.append(solution(n, students)).append('\n');
        }

        System.out.println(sb);
    }

    public static int solution(int n, int[] students) {
        int[] visit = new int[n]; // -1 : none, 0 : wait, 1 : team
        HashSet<Integer> studentSet = new HashSet<>();
        result = 0;

        for (int i = 0; i < n; i++) {
            if (visit[i] != 0) continue;
            DFS(i, students, visit, studentSet);
            studentSet.clear();
        }

        return result;
    }

    public static void DFS(int now, int[] students, int[] visit, HashSet<Integer> set) {
        int next = students[now];
        if (visit[next] == 0) {
            if (set.contains(next)) {
                visit[next] = 1;
            } else {
                set.add(next);
            }
            DFS(next, students, visit, set);
        }

        if (visit[now] == 0) {
            visit[now] = -1;
            result++;
        }
    }
}
