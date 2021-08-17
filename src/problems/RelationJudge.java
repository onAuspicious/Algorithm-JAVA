package problems;

public class RelationJudge {

    static int returnAvg(int[][] scores, int student) {
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            if (i != student) {
                maximum = Math.max(maximum, scores[i][student]);
                minimum = Math.min(minimum, scores[i][student]);
                sum += scores[i][student];
            }
        }

        if (scores[student][student] >= maximum || scores[student][student] <= minimum) {
            return sum / (scores.length - 1);
        }
        return (sum + scores[student][student]) / scores.length;
    }

    public String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < scores.length; i++) {
            int avg = returnAvg(scores, i);
            if (avg >= 90) {
                sb.append("A");
            } else if (80 <= avg) {
                sb.append("B");
            } else if (70 <= avg) {
                sb.append("C");
            } else if (50 <= avg) {
                sb.append("D");
            } else {
                sb.append("F");
            }
        }
        return sb.toString();
    }
}
