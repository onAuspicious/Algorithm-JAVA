package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlyMeToTheAlphaCentauri {

    public int solution(int distance) {
        int dis = 1;
        int cnt = 0;

        while (distance != 0) {
            if (distance >= dis * 2) {
                distance -= dis * 2;
                dis++;
                cnt+= 2;
            } else {
                if (dis >= distance) {
                    cnt++;
                } else {
                    cnt += 2;
                }
                break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        FlyMeToTheAlphaCentauri main = new FlyMeToTheAlphaCentauri();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            System.out.println(main.solution(Integer.parseInt(line[1]) - Integer.parseInt(line[0])));
        }
    }
}
