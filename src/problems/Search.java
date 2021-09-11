package problems;

import java.util.HashMap;

public class Search {

    public static String solution(String[] research, int n, int k) {
        int[][] res = new int[research.length][26];
        int search = 2 * n * k;
        int[] result = new int[26];

        for (int i = 0; i < research.length; i++) {
            for (int j = 0; j < research[i].length(); j++) {
                res[i][research[i].charAt(j) - 'a']++;
            }
        }

        for (int i = 0; i < research.length; i++) {
            if (i + n - 1 < research.length) {
                for (int j = 0; j < 26; j++) {
                    int cnt = 0;
                    for (int l = i; l < i + n; l++) {
                        if (res[l][j] == 0) {
                            cnt = 0;
                            break;
                        }
                        if (res[l][j] >= k) {
                            cnt += res[l][j];
                        }
                    }
                    if (cnt >= search) {
                        // save
                        result[j]++;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, result[i]);
        }

        if (max == 0) {
            return "None";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (max == result[i]) {
                    stringBuilder.append((char) (97 + i));
                    return stringBuilder.toString();
                }
            }
        }
        return "None";
    }

    public static void main(String[] args) {
        String[] res = new String[]{"yxxy","xxyyy","yz"};
        String solution = solution(res, 2, 1);
        System.out.println(solution);
    }
}
