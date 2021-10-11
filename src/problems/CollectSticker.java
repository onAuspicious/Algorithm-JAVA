package problems;

public class CollectSticker {

    public int solution(int sticker[]) {
        int n = sticker.length;
        int result = 0;

        if (n <= 3) {
            int r = 0;
            for (int i : sticker) r = Math.max(r, i);
            return r;
        }

        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];

        dp1[0] = sticker[0]; dp1[1] = sticker[1];
        dp1[2] = sticker[0] + sticker[2];
        dp2[0] = sticker[1]; dp2[1] = sticker[2];
        dp2[2] = sticker[1] + sticker[3];

        for (int i = 3; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2], dp1[i - 3]) + sticker[i];
            result = Math.max(result, dp1[i]);
        }

        for (int i = 3; i < n - 1; i++) {
            dp2[i] = Math.max(dp2[i - 2], dp2[i - 3]) + sticker[i + 1];
            result = Math.max(result, dp2[i]);
        }
        return result;
    }
}
