package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PasswordSearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> passwords = new HashMap<>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            passwords.put(line[0], line[1]);
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            sb.append(passwords.get(site)).append('\n');
        }
        System.out.println(sb);
    }
}
