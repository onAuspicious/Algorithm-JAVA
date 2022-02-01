package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;

public class StudentNumber {

    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        size = arr[0].length();

        for (int i = 1; i <= size; i++) {
            if (check(arr, i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean check(String[] arr, int k) {
        HashSet<String> set = new HashSet<>();

        for (String num : arr) {
            String substring = num.substring(size - k);
            if (!set.contains(substring)) {
                set.add(substring);
            } else {
                return false;
            }
        }

        return true;
    }
}
