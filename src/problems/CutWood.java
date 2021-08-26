package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutWood {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int want = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[0]);
        int[] trees = new int[n];
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(trees);

        long lt = 0;
        long rt = trees[n - 1];
        long mid;
        long cut;
        long result = 0;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            cut = 0;
            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    cut += trees[i] - mid;
                }
                if (cut >= want) {
                    break;
                }
            }
            if (cut >= want) {
                lt = mid + 1;
                result = mid;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(result);
    }
}
