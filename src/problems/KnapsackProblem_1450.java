package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class KnapsackProblem_1450 {

    static int[] left;
    static int[] right;
    static ArrayList<Integer> x = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();
    static int lt;
    static int rt;
    static int mid;
    static int val;

    public static void dfs(int level, int end, int sum, int c,  ArrayList<Integer> list, int[] arr) {
        if (sum > c) {
            return;
        }
        if (level == end) {
            list.add(sum);
        } else {
            dfs(level + 1, end, sum + arr[level], c, list, arr);
            dfs(level + 1, end, sum, c, list, arr);
        }
    }

    public static int find(int c, int now) {
        lt = 0;
        rt = y.size() - 1;
        val = -1;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (y.get(mid) + now <= c) {
                lt = mid + 1;
                val = mid;
            } else {
                rt = mid - 1;
            }
        }
        return val + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 물건의 개수
        int c = Integer.parseInt(input[1]); // 가방에 넣을 수 있는 최대 무게
        int result = 0;
        left = new int[n / 2];
        right = new int[n - n / 2];
        String[] line = br.readLine().split(" ");
        // 입력
        for (int i = 0; i < n/2; i++) {
            left[i] = Integer.parseInt(line[i]);
        }
        for (int i = 0; i < n - n / 2; i++) {
            right[i] = Integer.parseInt(line[i + n / 2]);
        }

        // 조합
        dfs(0, n / 2, 0, c, x, left);
        dfs(0, n - n / 2, 0, c, y, right);
        y.sort(Comparator.naturalOrder());
        x.sort(Comparator.naturalOrder());
        int end = y.size() - 1;

        // 판단
        int rv;
        for (Integer now : x) {
            if ((rv = find(c, now)) > 0) {
                result += rv;
            }
        }
        System.out.println(result);
    }
}