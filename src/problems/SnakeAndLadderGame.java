package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class SnakeAndLadderGame {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        HashMap<Integer, Integer> move = new HashMap<>();
        int[] board = new int[101];
        int ladder = Integer.parseInt(split[0]);
        int snake = Integer.parseInt(split[1]);
        int result = 0;

        // ladder init
        for (int i = 0; i < ladder + snake; i++) {
            String[] input = br.readLine().split(" ");
            move.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(1);

        while (!dq.isEmpty()) {
            int length = dq.size();
            result++;
            for (int i = 0; i < length; i++) {
                int pop = dq.removeFirst();

                for (int j = 1; j <= 6; j++) {
                    int next = pop + j;
                    if (next <= 100) {
                        if (move.containsKey(next) && board[move.get(next)] == 0) {
                            board[move.get(next)] = result;
                            dq.add(move.get(next));
                        } else if (!move.containsKey(next) && board[next] == 0) {
                            board[next] = result;
                            dq.add(next);
                        }
                    }
                }
            }
        }
        System.out.println(board[100]);
    }
}
