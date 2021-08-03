package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BetterThenAVG {

    public void solution(String[] list) {
        int num = Integer.parseInt(list[0]);
        double avg = 0D;
        double result = 0D;

        for (int i = 1; i < list.length; i++) {
            avg += Double.parseDouble(list[i]);
        }

        avg /= num;

        for (int i = 1; i < list.length; i++) {
            if (Double.parseDouble(list[i]) > avg) {
                result += 1;
            }
        }

        result /= num;
        System.out.println(String.format("%.3f", result*100) + "%");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] list = br.readLine().split(" ");
            BetterThenAVG betterThenAVG = new BetterThenAVG();
            betterThenAVG.solution(list);
        }
        br.close();
    }
}
