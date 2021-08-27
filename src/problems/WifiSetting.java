package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WifiSetting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[n];  //house

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int cnt;
        int result = Integer.MIN_VALUE;
        int distance;
        int lt = 0;
        int rt = arr[n - 1] - arr[0];
        int mid;
        int now;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            now = arr[0];
            cnt = 0;
            distance = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if (arr[i] - now >= mid) {
                    cnt++;
                    distance = Math.min(distance, arr[i] - now);
                    now = arr[i];
                }
            }
            if (cnt >= m - 1) {
                lt = mid + 1;
                result = Math.max(result, distance);
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(result);
    }
}
