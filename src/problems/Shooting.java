package problems;

public class Shooting {

    int[] point = new int[11];
    int saveA;
    int result = 0;
    int[] resultArr;
    boolean state;

    public void dfs(int level, int pointR, int pointA, int n, int[] info) {
        if (level == 11 || n == 0) {
            state = true;
            if (n > 0) {
                point[10] = n;
                state = false;
            }
            if (pointR - pointA > result) {
                resultArr = point.clone();
                result = pointR - pointA;
            } else if (pointR - pointA == result && result != 0) {
                for (int i = 10; i > -1; i--) {
                    if (resultArr[i] < point[i]) {
                        resultArr = point.clone();
                        break;
                    }
                }
                result = pointR - pointA;
            }
            if (!state) {
                point[10] = 0;
            }
        } else {
            // 점수 획득 or 비기기
            if (info[level] < n) {
                // win
                if (info[level] == 0) {
                    point[level] = 1;
                    dfs(level + 1, pointR + 10 - level, pointA, n - 1, info);
                } else {
                    point[level] = info[level] + 1;
                    dfs(level + 1, pointR + 10 - level, pointA - (10 - level), n - info[level] - 1, info);
                }
                point[level] = 0;
            }
            if (info[level] <= n) {
                // draw
                if (info[level] != 0) {
                    point[level] = info[level];
                    dfs(level + 1, pointR, pointA, n - info[level], info);
                    point[level] = 0;
                }
            }
            // 점수 획득 x
            dfs(level + 1, pointR, pointA, n, info);
        }
    }

    public int[] solution(int n, int[] info) {
        int pointA = 0;
        // make pointA
        for (int i = 0; i < 11; i++) {
            if (info[i] > 0) {
                pointA += 10 - i;
            }
        }
        saveA = pointA;

        dfs(0, 0, pointA, n, info);
        if (result == 0) {
            return new int[]{-1};
        }
        return resultArr;
    }

    public static void main(String[] args) {
        Shooting shooting = new Shooting();
        int[] solution = shooting.solution(10, new int[]{1,1,1,1,2,1,0,1,1,1,1});
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }
}
