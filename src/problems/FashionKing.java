package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FashionKing {

    static HashMap<String, Integer> map = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    static void solution(int n) throws IOException {
        int result = 1;

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }
        for (String s : map.keySet()) {
            result *= map.get(s) + 1;
        }
        sb.append(result - 1).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            solution(input);
            map.clear();
        }
        System.out.println(sb);
    }
}
