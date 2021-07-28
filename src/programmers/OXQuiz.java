package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OXQuiz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int point = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            String[] list = br.readLine().split("");
            for (String s : list) {
                if (s.equals("O")) {
                    point += 1;
                } else {
                    point = 0;
                }
                result += point;
            }
            System.out.println(result);
            result = 0;
            point = 0;
        }
    }
}
