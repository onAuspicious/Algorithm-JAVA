package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiple {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        System.out.println(solution(a, b, c));
    }

    private static long solution(int a, int b, int c) {
        if (b == 1) {
            return a;
        } else {
            long now = solution(a, b / 2, c);
            if (b % 2 == 0) {
                return (now % c * now % c) % c;
            } else {
                return (now % c * now % c * a % c) % c;
            }
        }
    }
}
