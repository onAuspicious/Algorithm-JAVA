package problems;

public class Students {

    public int solution(int[] student, int k) {
        int k_cnt;
        int result = 0;

        for (int i = 0; i < student.length; i++) {
            k_cnt = 0;
            for (int j = i; j < student.length; j++) {
                if (student[j] == 1) {
                    k_cnt++;
                }
                if (k_cnt == k) {
                    result++;
                } else if (k_cnt > k) {
                    break;
                }
            }
        }
        return result;
    }
}
