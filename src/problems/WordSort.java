package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashSet<String> check = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            if (!check.contains(tmp)) {
                check.add(tmp);
                list.add(tmp);
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return 0;
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (String s : list) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
