package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PhoneCallList {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // num of phoneNumber
            String[] numbers = new String[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = br.readLine();
            }

            if (checkConsistency(n, numbers)) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);
    }

    public static boolean checkConsistency(int n, String[] numbers) {
        // 1. sort
        Arrays.sort(numbers);

        // 2. create hashSet
        Set<String> numSet = new HashSet<>();

        // 3. check number
        for (int i = 0; i < n; i++) {
            String now = numbers[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < now.length(); j++) {
                sb.append(now.charAt(j));
                if (numSet.contains(sb.toString())) return false;
            }
            numSet.add(now);
        }

        return true;
    }
}
