package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DeutBoJap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> map = new HashSet<>();
        String[] input = br.readLine().split(" ");
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
            map.add(br.readLine());
        }

        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            String line = br.readLine();
            if (map.contains(line)) {
                result.add(line);
            }
        }

        result.sort(Comparator.naturalOrder());
        sb.append(result.size());

        for (String string : result) {
            sb.append(string).append('\n');
        }
        System.out.println(sb);
    }
}
