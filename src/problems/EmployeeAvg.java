package problems;

import java.util.HashSet;
import java.util.Random;

public class EmployeeAvg {

    static Random random = new Random();

    public static void main(String[] args) {
        solution(3);
    }

    public static void solution(int n) {
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> numberSet = new HashSet<>();
        double avg = 0;
        int number;

        for (int i = 0; i < n; i++) {
            do {
                number = random.nextInt(100000);
            } while (numberSet.contains(number));

            numberSet.add(number);
            int point = random.nextInt(101);
            sb.append("NT").append(number).append(' ').append(point).append('\n');
            avg += point;
        }

        sb.append("생성된 점수의 평균은 ").append(String.format("%.1f", avg / n)).append("점입니다.");

        System.out.println(sb.toString());
    }
}
