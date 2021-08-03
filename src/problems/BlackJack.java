package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJack {

    public int solution(int[] list, int goal) {
        int result = 0;
        int now;

        for (int i = 0; i < list.length - 2; i++) {
            for (int j = i+1; j < list.length - 1; j++) {
                for (int k = j+1; k < list.length; k++) {
                    now = list[i] + list[j] + list[k];
                    if (goal - now >= 0 && result < now) {
                        result = now;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BlackJack main = new BlackJack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        String[] split = br.readLine().split(" ");
        int[] list = new int[split.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(split[i]);
        }
        System.out.println(main.solution(list, M));
    }
}
