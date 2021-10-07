package problems;

import java.util.*;

public class CameraSetting {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] < b[1]) {
                    return -1;
                } else if (a[1] > b[1]) {
                    return 1;
                } else {
                    return a[0] - b[0];
                }
            }
        });

        int result = 1;
        int end = routes[0][1];
        for (int[] route : routes) {
            if (route[0] > end) {
                end = route[1];
                result++;
            }
        }
        return result;
    }
}
