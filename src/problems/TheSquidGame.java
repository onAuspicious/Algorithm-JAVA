package problems;

public class TheSquidGame {

    public int solution(int[] arr) {
        long now = 0;
        int result = 0;

        for (int i : arr) {
            now += i;
            if (now > 0) result++;
        }

        return result;
    }
}
