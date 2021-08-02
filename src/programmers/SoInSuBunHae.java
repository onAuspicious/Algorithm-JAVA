package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SoInSuBunHae {

    public List<Integer> solution(int num) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 2;

        while (num != 1) {
            if (num % i == 0) {
                num /= i;
                result.add(i);
            } else {
                i += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        SoInSuBunHae main = new SoInSuBunHae();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (Integer integer : main.solution(N)) {
            System.out.println(integer);
        }
    }
}
