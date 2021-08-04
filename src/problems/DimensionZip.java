package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DimensionZip {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] list = new int[s.length];
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> duple = new HashSet<>();

        for (int i = 0; i < s.length; i++) {
            list[i] = Integer.parseInt(s[i]);
        }
        int[] sortedNum = list.clone();
        Arrays.sort(sortedNum);

        int idx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sortedNum[i])) {
                map.put(sortedNum[i], idx);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
