package problems;

public class Network_P {

    static boolean[] check;

    public int solution(int n, int[][] computers) {
        check = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                result++;
                check[i] = true;
                DFS(i, computers, n);
            }
        }
        return result;
    }

    static void DFS(int now, int[][] computers, int n) {
        int[] computer = computers[now];
        for (int i = 0; i < n; i++) {
            if (computer[i] == 1 && !check[i]) {
                check[i] = true;
                DFS(i, computers, n);
            }
        }
    }
}
