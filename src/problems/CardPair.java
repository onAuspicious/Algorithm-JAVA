package problems;

import java.util.*;

public class CardPair {

    static int max = 0;
    static int[] combination;
    static HashSet<Integer> cardSet = new HashSet<>();
    static int[][] copy;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int startX, startY;
    static ArrayDeque<Node> dq = new ArrayDeque<>();
    static boolean[][] check;

    static class Node {
        int x;
        int y;
        int move;

        public Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public int solution(int[][] board, int r, int c) {
        // 카드 몇 장 있는지 카운트 최대 4장
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        // 출발지 static 변경
        startX = r;
        startY = c;

        // 카드 순서 조합 만들고 BFS
        combination = new int[max];
        DFS(0, board);
        return answer;
    }

    // 카드 찾는 순서 조합 생성
    static void DFS(int level, int[][] board) {
        // BFS start
        if (level == max) {
            copy = copy(board);
            cardSearch();
        } else {
            for (int i = 1; i <= max; i++) {
                if (!cardSet.contains(i)) {
                    combination[level] = i;
                    cardSet.add(i);
                    DFS(level + 1, board);
                    cardSet.remove(i);
                }
            }
        }
    }

    // copy board 에서 combination 기반으로 탐색
    // Enter, Ctrl 유의
    static void cardSearch() {
        dq.clear();
        dq.offerLast(new Node(startX, startY, 0));
        boolean state = false; // false = 찾아야함, true = 없애야함
        check = new boolean[4][4]; // 중복방문 제거
        check[startX][startY] = true;
        int time = 0; // 모두 없앨때까지 걸리는 시간

        for (int parseInt : combination) {
            System.out.print("now: " + parseInt + " ");
        }
        System.out.println();

        for (int goal : combination) {
            int cnt = 0;
//            System.out.println(goal + " " + time);
            while (cnt < 2) {
                Node now = dq.removeFirst();
                // now 가 원하는 goal 일 때 Enter
                // 해야할 것들 cnt++, check 초기화, 현재 위치 0, time 추가
                if (copy[now.x][now.y] == goal) {
                    cnt++;
                    copy[now.x][now.y] = 0;
                    check = new boolean[4][4];
                    check[now.x][now.y] = true;
                    time += now.move + 1;
                    dq.clear();
                    dq.offerLast(new Node(now.x, now.y, 0));

                    for (int[] ints : copy) {
                        for (int i : ints) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                    System.out.println(time);
                    System.out.println();
                    continue;
                }

                // 상하좌우
                for (int i = 0; i < 4; i++) {
                    int tmpx = now.x + dx[i];
                    int tmpy = now.y + dy[i];
                    // 이동 가능한 칸
                    if (0 <= tmpx && tmpx < 4 && 0 <= tmpy && tmpy < 4 && !check[tmpx][tmpy]) {
                        dq.offerLast(new Node(tmpx, tmpy, now.move + 1));
                        check[tmpx][tmpy] = true;
                    }
                }
                // Ctrl 상하좌우
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; j <= 4; j++) {
                        int tmpx = now.x + dx[i] * j;
                        int tmpy = now.y +  dy[i] * j;
                        if (0 <= tmpx && tmpx < 4 && 0 <= tmpy && tmpy < 4) {
                            if (copy[tmpx][tmpy] > 0 && !check[tmpx][tmpy]) {
                                dq.offerLast(new Node(tmpx, tmpy, now.move + 1));
                                check[tmpx][tmpy] = true;
                                break;
                            }
                        } else {
                            tmpx -= dx[i];
                            tmpy -= dy[i];
                            if(!check[tmpx][tmpy]) {
                                dq.offerLast(new Node(tmpx, tmpy, now.move + 1));
                                check[tmpx][tmpy] = true;
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(time);
        answer = Math.min(answer, time);
    }

    static int[][] copy(int[][] board) {
        int[][] result = new int[4][4];
        for (int i = 0; i< 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}};
        CardPair cardPair = new CardPair();
        int solution = cardPair.solution(a, 1, 0);
        System.out.println(solution);
    }
}
