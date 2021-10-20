package problems;

public class BallMoveSimulation {

    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    static int w, h; // == n, m
    static int gx, gy; // == x, y

    public long solution(int n, int m, int x, int y, int[][] queries) {
        // 1) star 로 부터 역추적해서 기준점 생성
        int px = x, py = y;
        h = n; w = m; gx = x; gy = y;
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] query = queries[i];
            px -= dx[query[0]] * query[1];
            py -= dy[query[0]] * query[1];
            if (px < 0) {
                px = 0;
            } else if(px >= h) {
                px = h - 1;
            }
            if (py < 0) {
                py = 0;
            } else if (py >= w) {
                py = w - 1;
            }
        }
        // 1.5) queries 로 목표에 도달할 수 없을 때
        if (!queryExecute(px, py, queries)) return 0;

        // 2) 기준점에서 이분탐색으로 상,하,좌,우 최대치 구하기
        int left = searchLeft(px, py, queries);
        int right = searchRight(px, py, queries);
        int up = searchUp(px, py, queries);
        int down = searchDown(px, py, queries);

        return (long)(right - left + 1) * (long)(down - up + 1);
    }

    // 기준점에서 왼쪽 끝
    public static int searchLeft(int rx, int ry, int[][] queries) {
        int mid;
        int leftResult = ry;
        int ly = 0;
        while (ly <= ry) {
            mid = (ly + ry) / 2;
            if (queryExecute(rx, mid, queries)) {
                leftResult = mid;
                ry = mid - 1;
            } else {
                ly = mid + 1;
            }
        }
        return leftResult;
    }

    // 기준점에서 오른쪽 끝
    public static int searchRight(int rx, int ry, int[][] queries) {
        int mid;
        int result = ry;
        int ly = w - 1;
        while (ry <= ly) {
            mid = (ly + ry) / 2;
            if (queryExecute(rx, mid, queries)) {
                result = mid;
                ry = mid + 1;
            } else {
                ly = mid - 1;
            }
        }
        return result;
    }

    // 기준 점에서 왼쪽위 끝
    public static int searchUp(int rx, int ry, int[][] queries) {
        int mid;
        int lt = 0; int rt = rx;
        int result = rx;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (queryExecute(mid, ry, queries)) {
                result = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return result;
    }

    // 기준 점에서 아래 끝
    public static int searchDown(int rx, int ry, int[][] queries) {
        int mid;
        int lt = rx; int rt = h - 1;
        int result = rx;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (queryExecute(mid, ry, queries)) {
                result = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return result;
    }

    public static boolean queryExecute(int x, int y, int[][] queries) {
        for (int[] query : queries) {
            x += dx[query[0]] * query[1];
            y += dy[query[0]] * query[1];
            if (x < 0) {
                x = 0;
            } else if(x >= h) {
                x = h - 1;
            }
            if (y < 0) {
                y = 0;
            } else if (y >= w) {
                y = w - 1;
            }
        }
        if (x == gx && y == gy) {
            return true;
        }
        return false;
    }
}
