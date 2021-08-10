package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcCrossing {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public void calculate(int[] numbers, int[] calc, int num, int result, int now) {
        if (now == num) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        } else {
            for (int i = 0; i < 4; i++) {
                if (calc[i] != 0) {
                    if (i == 0) {
                        calc[i]--;
                        result += numbers[now];
                        calculate(numbers, calc, num, result, now + 1);
                        calc[i]++;
                        result -= numbers[now];
                    } else if (i == 1) {
                        calc[i]--;
                        result -= numbers[now];
                        calculate(numbers, calc, num, result, now + 1);
                        calc[i]++;
                        result += numbers[now];
                    } else if (i == 2) {
                        calc[i]--;
                        result *= numbers[now];
                        calculate(numbers, calc, num, result, now + 1);
                        calc[i]++;
                        result /= numbers[now];
                    } else {
                        calc[i]--;
                        result /= numbers[now];
                        calculate(numbers, calc, num, result, now + 1);
                        calc[i]++;
                        result *= numbers[now];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CalcCrossing main = new CalcCrossing();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int[] numbers = new int[num];
        int[] calc = new int[4];

        String[] input1 = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            numbers[i] = Integer.parseInt(input1[i]);
        }

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(input2[i]);
        }

        main.calculate(numbers, calc, num, numbers[0], 1);

        sb.append(max).append("\n").append(min);

        System.out.println(sb);
    }
}
