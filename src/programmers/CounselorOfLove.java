package programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class CounselorOfLove {
    long result = 80000000000L;

    public long solution(int[][] worms) {
        int plus = worms.length / 2;
        int minus = worms.length / 2;
        int[] save = new int[]{0, 0};
        DFS(save, plus, minus, worms, 0);
        return result;
    }

    public void DFS(int[] save, int plus, int minus, int[][] worms, int level) {
        if (level == worms.length) {
            result = (long) Math.min(result, Math.pow(save[0], 2) + Math.pow(save[1], 2));
            System.out.println(result);
        } else {
            if (plus == 0) {
                DFS(new int[]{save[0] - worms[level][0], save[1] - worms[level][1]}, plus, minus-1, worms, level+1);
            } else if (minus == 0) {
                DFS(new int[]{save[0] + worms[level][0], save[1] + worms[level][1]}, plus - 1, minus, worms, level + 1);
            } else {
                DFS(new int[]{save[0] - worms[level][0], save[1] - worms[level][1]}, plus, minus -1, worms, level+1);
                DFS(new int[]{save[0] + worms[level][0], save[1] + worms[level][1]}, plus-1, minus, worms, level + 1);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T;
        T = scanner.nextInt();

        for (int testCase = 0; testCase < T; testCase++) {
            int N = scanner.nextInt();
            int[][] worms = new int[N][2];

            CounselorOfLove counselorOfLove = new CounselorOfLove();

            for (int i = 0; i < N; i++) {
                worms[i][0] = scanner.nextInt();
                worms[i][1] = scanner.nextInt();
            }

            long solution = counselorOfLove.solution(worms);
            System.out.println(solution);
        }
    }
}
