package problems;

public class Fatigue {

    static boolean[] check = new boolean[8];
    static int result = 0;
    static int size;

    public int solution(int k, int[][] dungeons) {
        size = dungeons.length;
        DFS(0, 0, k, dungeons);
        return result;
    }

    public static void DFS(int level, int cnt, int k, int[][] dungeons) {
        if (level == size) {
            result = Math.max(result, cnt);
        } else {
            for (int i = 0; i < size; i++) {
                if (!check[i]) {
                    if (k >= dungeons[i][0]) {
                        check[i] = true;
                        DFS(level + 1, cnt + 1, k - dungeons[i][1], dungeons);
                        check[i] = false;
                    } else {
                        check[i] = true;
                        DFS(level + 1, cnt, k - dungeons[i][1], dungeons);
                        check[i] = false;
                    }
                }
            }
        }
    }
}
