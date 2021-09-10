package problems;

import java.util.ArrayList;

public class TakeAPicture {

    static char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] permutation = new char[8];
    static boolean[] check = new boolean[8];
    static int result;

    public boolean dataCheck(int n, String[] data) {
        int lt = 0;
        int rt = 0;
        int num;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 8; j++) {
                if (data[i].charAt(0) == permutation[j]) {
                    lt = j;
                }
                if (data[i].charAt(2) == permutation[j]) {
                    rt = j;
                }
            }
//            System.out.println(lt + "  " + rt);
            num = data[i].charAt(4) - '0';
            if (data[i].charAt(3) == '=') {
                System.out.println(Math.abs(lt - rt) + " " + num);
                if (Math.abs(lt - rt) != 1) {
                    return false;
                }
            } else if (data[i].charAt(3) == '<') {
                if (Math.abs(lt - rt) >= num) {
                    return false;
                }
            } else {
                if (Math.abs(lt - rt) <= num+1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void dfs(int level, int n, String[] data) {
        if (level == 8) {
            // function call
            if (dataCheck(n, data)) {
                result++;
            }
        } else {
            for (int i = 0; i < 8; i++) {
                if (!check[i]) {
                    check[i] = true;
                    permutation[level] = friends[i];
                    dfs(level + 1, n, data);
                    check[i] = false;
                }
            }
        }
    }

    public int solution(int n, String[] data) {
        result = 0;
        dfs(0, n, data);
        return result;
    }

    public static void main(String[] args) {
        TakeAPicture takeAPicture = new TakeAPicture();
        int solution = takeAPicture.solution(2, new String[]{"N~F=0", "R~T>2"});
        System.out.println(solution);
    }
}
