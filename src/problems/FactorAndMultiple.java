package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorAndMultiple {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int left; int right;

        while (true) {
            String[] input = br.readLine().split(" ");
            left = Integer.parseInt(input[0]);
            right = Integer.parseInt(input[1]);
            if (left == 0 && right == 0) {
                break;
            } else {
                if (left % right == 0) {
                    sb.append("multiple").append('\n');
                } else if (right % left == 0) {
                    sb.append("factor").append('\n');
                } else {
                    sb.append("neither").append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
