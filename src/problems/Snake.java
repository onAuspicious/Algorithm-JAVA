package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Snake {

    static int snakeDirection = 1; // 초기값 = 동쪽
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayDeque<Point> snake = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        int time = 0;
        int[][] board = new int[n][n];
        board[0][0] = 2; // SNAKE
        snake.add(new Point(0, 0));

        for (int i = 0; i < l; i++) {
            String[] apple = br.readLine().split(" ");
            board[Integer.parseInt(apple[0]) - 1][Integer.parseInt(apple[1]) - 1] = 1; // APPLE = 1
        }

        int m = Integer.parseInt(br.readLine()); // moving case
        boolean endState = true;

        while (endState && m > 0) {
            String[] move = br.readLine().split(" ");
            int t = Integer.parseInt(move[0]) - time;

            for (int j = 0; j < t; j++) {
                time++;
                Point front = snake.getFirst(); // 머리 + 1칸
                int nextX = front.x + dx[snakeDirection];
                int nextY = front.y + dy[snakeDirection];
                if (0 <= nextX && nextX < n && 0 <= nextY && nextY < n) {
                    if (board[nextX][nextY] == 0) {
                        Point removed = snake.removeLast();
                        board[removed.x][removed.y] = 0;
                    } else if (board[nextX][nextY] == 2) {
                        endState = false;
                        break;
                    }
                    board[nextX][nextY] = 2;
                    snake.offerFirst(new Point(nextX, nextY));
                } else {
                    endState = false;
                    break;
                }
            }
            // direction change
            if (move[1].equals("D")) {
                snakeDirection = (snakeDirection + 1) % 4;
            } else {
                snakeDirection = (snakeDirection + 3) % 4;
            }
            m--;
        }

        while (endState) {
            time++;
            Point first = snake.getFirst();
            int nextX = first.x + dx[snakeDirection];
            int nextY = first.y + dy[snakeDirection];
            if (0 <= nextX && nextX < n && 0 <= nextY && nextY < n) {
                if (board[nextX][nextY] == 0) {
                    Point removed = snake.removeLast();
                    board[removed.x][removed.y] = 0;
                } else if (board[nextX][nextY] == 2) {
                    break;
                }
                board[nextX][nextY] = 2;
                snake.offerFirst(new Point(nextX, nextY));
            } else {
                endState = false;
            }
        }
        System.out.println(time);
    }
}
