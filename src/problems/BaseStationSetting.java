package problems;

public class BaseStationSetting {
    public int solution(int n, int[] stations, int w) {
        int now = 1; // 전파가 닿지 않는 가장 왼쪽 value
        int cnt = 0;
        int range = 2 * w + 1;
        for (int station : stations) {
            // left check
            int left = station - w;
            if (now < left) {
                cnt += (left - now) / range;
                if ((left - now) % range != 0) cnt++;
            }
            now = station + w + 1;
        }

        if (now < n + 1) {
            cnt += (n + 1 - now) / range;
            if ((n + 1 - now) % range != 0) cnt++;
        }

        return cnt;
    }
}
