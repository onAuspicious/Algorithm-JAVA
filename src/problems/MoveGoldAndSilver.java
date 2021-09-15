package problems;

public class MoveGoldAndSilver {

    static long max = 100000000000000L;

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long start = 0;
        long end = max;
        long mid;
        long result = max;

        while (start <= end) {
            long gold_sum = 0;
            long silver_sum = 0;
            long gold_silver_sum = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < g.length; i++) {
                long gold_now = g[i];
                long silver_now = s[i];
                long time = mid / (t[i] * 2L);
                if (mid % (t[i] *2L) >= t[i]) time++;

                gold_sum += Math.min(gold_now, w[i] * time);
                silver_sum += Math.min(silver_now, w[i] * time);
                gold_silver_sum += Math.min(gold_now + silver_now, w[i] * time);
            }

            if (gold_sum >= a && silver_sum >= b && gold_silver_sum >= a + b) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 90;
        int b = 500;
        int[] g = new int[]{70, 70, 0};
        int[] s = new int[]{0, 0, 500};
        int[] w = new int[]{100, 100, 2};
        int[] t = new int[]{4, 8, 1};
        MoveGoldAndSilver moveGoldAndSilver = new MoveGoldAndSilver();
        long solution = moveGoldAndSilver.solution(a, b, g, s, w, t);
        System.out.println(solution);
    }
}
