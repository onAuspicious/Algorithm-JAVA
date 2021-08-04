package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DimensionSort {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String[]> list = new ArrayList<>();
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            list.add(br.readLine().split(" "));
//        }
//        list.sort((o1, o2) -> {
//            if (Integer.parseInt(o1[0]) > Integer.parseInt(o2[0])) {
//                return 1;
//            } else if (Integer.parseInt(o1[0]) < Integer.parseInt(o2[0])) {
//                return -1;
//            } else {
//                return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
//            }
//        });
//        for (String[] s : list) {
//            System.out.println(s[0] + " " + s[1]);
//        }
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
        }
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                return -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int[] i : list) {
            sb.append(i[0]).append(" ").append(i[1]).append('\n');
        }
        System.out.println(sb);
    }
}
