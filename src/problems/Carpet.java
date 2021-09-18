package problems;

public class Carpet {

    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            int now = yellow / i;
            if (2 * (i + now) + 4 == brown && yellow == now * i) {
                return new int[] {Math.max(i, now) + 2, Math.min(i, now) + 2};
            }
        }
        return new int[]{0, 0};
    }
}
