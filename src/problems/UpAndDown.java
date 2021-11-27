package problems;

public class UpAndDown {

    static int mod = 1000000007;

    public static void main(String[] args) {
        UpAndDown line2 = new UpAndDown();
        int solution = line2.solution(new int[]{1,1,1,1,2,2,0});
        System.out.println(solution);
    }

    public int solution(int[] arr) {
        int result = 0;

        boolean state = false; // true -> up, false -> down
        int cur = arr[0];
        int cnt = 0; // 오르막 개수

        for (int now : arr) {
            // up state
            if (state) {
                if (now > cur) {
                    cur = now;
                    cnt++;
                } else if (now < cur) {
                    state = false;
                    cur = now;
                    result = (result + --cnt) % mod;
                } else {
                    cnt = 0;
                    state = false;
                }
            } else {
                if (now > cur) {
                    cnt = 2;
                    cur = now;
                    state = true;
                } else if (now < cur) {
                    cur = now;
                    result = (result + cnt) % mod;
                } else {
                    cnt = 0;
                }
            }
            System.out.println("now : "+ now + " result : " + result + " cnt : " + cnt + " state " + state);
        }
        return result;
    }
}
