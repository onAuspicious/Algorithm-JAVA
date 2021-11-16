package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordMathematics {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphaValues = new int[26];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                alphaValues[input.charAt(j) - 'A'] += (int) Math.pow(10, input.length() - j - 1);
            }
        }

        Arrays.sort(alphaValues);
        int cur = 9;
        int result = 0;
        for (int i = 25; i > 15; i--) {
            result += cur-- * alphaValues[i];
        }
        System.out.println(result);
    }
}
