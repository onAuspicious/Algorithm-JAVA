package problems;

public class ExpectRelation {
    public int solution(int n, int a, int b)
    {
        int result = 0;
        while(a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            result++;
        }
        return result;
    }
}
