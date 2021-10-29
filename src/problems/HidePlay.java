package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class HidePlay {

    static int n, k;
    static int max = Integer.MAX_VALUE;
    static int[] moveCnt = new int[100001];
    static int[] visitCnt = new int[100001];
    static ArrayDeque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int cnt = 0;
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        for (int i = 0; i < 100001; i++) {
            moveCnt[i] = max;
        }

        dq.offerLast(n);
        moveCnt[n] = 0;
        visitCnt[n] = 1;
        boolean breakPoint = true;
        while (!dq.isEmpty() && breakPoint) {
            int size = dq.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int now = dq.removeFirst();
                if (now + 1 <= 100000 && moveCnt[now + 1] >= cnt) {
                    moveCnt[now + 1] = cnt;
                    visitCnt[now + 1]++;
                    dq.offerLast(now + 1);
                }
                if (now - 1 >= 0 && moveCnt[now - 1] >= cnt) {
                    moveCnt[now - 1] = cnt;
                    visitCnt[now - 1]++;
                    dq.offerLast(now - 1);
                }
                if (now * 2 <= 100000 && moveCnt[2 * now] >= cnt) {
                    moveCnt[2 * now] = cnt;
                    visitCnt[2 * now]++;
                    dq.offerLast(now * 2);
                }
                if (visitCnt[k] > 0) {
                    breakPoint = false;
                }
            }
        }
        sb.append(moveCnt[k]).append('\n').append(visitCnt[k]);
        System.out.println(sb);
    }
}
