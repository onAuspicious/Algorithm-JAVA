package problems;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimalNumber {

    public ArrayList<Integer> findPriority() {
        int[] memo = new int[1001];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i < 1001; i++) {
            if (memo[i] == 0) {
                for (int j = 1; j <1000/i+1; j++) {
                    memo[j*i] = 1;
                }
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> priority = new PrimalNumber().findPriority();
        int N = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if (priority.contains(num)) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
