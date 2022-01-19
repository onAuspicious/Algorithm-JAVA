package problems;

public class CountPrimeInK {

    int result = 0;

    public int solution(int n, int k) {
        String num = change(n, k);
        int cur = 0;
        boolean state = false;

        for (int i = 0; i < num.length(); i++) {
            if (!state && num.charAt(i) != '0') {
                state = true;
                cur = i;
                continue;
            }
            if (state && num.charAt(i) == '0') {
                state = false;
                check(Long.parseLong(num.substring(cur, i)));
            }
        }
        if (num.charAt(num.length() - 1) != '0') {
            check(Long.parseLong(num.substring(cur)));
        }

        return result;
    }

    public void check(long num) {
        if (num < 2) return;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return;
            }
        }
        result++;
    }

    public String change(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n%k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        CountPrimeInK countPrimeInK = new CountPrimeInK();
        int solution = countPrimeInK.solution(1100011, 10);
        System.out.println(solution);
    }
}
