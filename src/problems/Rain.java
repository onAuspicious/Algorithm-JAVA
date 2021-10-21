package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int h = Integer.parseInt(split[0]);
        int w = Integer.parseInt(split[1]);
        String[] input = br.readLine().split(" ");
        int[] board = new int[w];
        for (int i = 0; i < w; i++) {
            board[i] = Integer.parseInt(input[i]);
        }
        int result = 0;

        for (int i = 1; i <= h; i++) {
            boolean state = false; // false : 아직 아무 기둥도 없는 경우, true : 기둥 있는 경우
            int cnt = 0; // 해당 높이에 쌓인 빗물의 개수
            for (int j = 0; j < w; j++) {
                if (board[j] >= i) {
                    if (state) {
                        result += cnt;
                        cnt = 0;
                    } else {
                        state = true;
                    }
                } else if (state) {
                    cnt++;
                }
            }
        }
        System.out.println(result);
    }
}
