package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ArrayChange {

    static int[][] board;
    static int[][] changes;
    static Stack<int[]> permutation =  new Stack<>();
    static boolean[] memo;
    static int K;
    static int before;
    static int after;
    static int result = Integer.MAX_VALUE;

    static void rotation(int[][] clone) {
        for (int[] change : permutation) {
            for (int i = 1; i < change[2] + 1; i++) {
                // 위
                before = clone[change[0] - i][change[1] - i];
                for (int j = change[1] - i + 1; j < change[1] + i + 1; j++) {
                    after = clone[change[0] - i][j];
                    clone[change[0] - i][j] = before;
                    before = after;
                }

                for (int j = change[0] - i + 1; j < change[0] + i + 1; j++) {
                    after = clone[j][change[1] + i];
                    clone[j][change[1] + i] = before;
                    before = after;
                }

                for (int j = change[1] + i - 1; j > change[1] - i - 1; j--) {
                    after = clone[change[0] + i][j];
                    clone[change[0] + i][j] = before;
                    before = after;
                }

                for (int j = change[0] + i - 1; j > change[0] - i - 1; j--) {
                    after = clone[j][change[1] - i];
                    clone[j][change[1] - i] = before;
                    before = after;
                }
            }
        }
        int min;
        for (int[] line : clone) {
            min = 0;
            for (int i : line) {
                min += i;
            }
            result = Math.min(result, min);
        }
    }

    static void permutation(int idx, int count) {
        if (count == K) {
            int[][] copy = new int[board.length][];
            for (int i = 0; i < board.length; i++) {
                copy[i] = board[i].clone();
            }
            rotation(copy);
        } else {
            for (int i = 0; i < K; i++) {
                if (!memo[i]) {
                    memo[i] = true;
                    permutation.add(changes[i]);
                    permutation(idx + 1, count + 1);
                    permutation.pop();
                    memo[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[2]);
        board = new int[Integer.parseInt(input[0])][Integer.parseInt(input[1])];
        changes = new int[K][3];
        memo = new boolean[K];

        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < K; i++) {
            String[] line = br.readLine().split(" ");
            changes[i] = new int[]{Integer.parseInt(line[0])-1, Integer.parseInt(line[1])-1, Integer.parseInt(line[2])};
        }

        permutation(0,0);

        System.out.println(result);
    }
}
