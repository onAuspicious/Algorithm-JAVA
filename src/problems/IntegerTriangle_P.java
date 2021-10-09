package problems;

public class IntegerTriangle_P {
    public int solution(int[][] triangle) {
        int result = 0;
        for (int i = 1; i < triangle.length; i++) {
            int size = triangle[i].length;
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == size - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                }
                result = Math.max(result, triangle[i][j]);
            }
        }
        return result;
    }
}
