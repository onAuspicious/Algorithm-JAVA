package problems;

public class StringCompression {
    public int solution(String s) {
        int result = s.length();

        for (int i = 1; i < s.length()/2 + 1; i++) {
            String temp = "";
            String nowString = "";
            String substring = "";
            Integer count = 1;

            for (int j = 0; j < s.length() / i + 1; j++) {
                if (j * i + i <= s.length()) {
                    substring = s.substring(j * i, j * i + i);
                } else {
                    substring = s.substring(j * i);
                }

                if (nowString.equals(substring)) {
                    count += 1;
                } else {
                    if (count > 1) {
                        temp += count.toString() + nowString;
                    } else {
                        temp += nowString;
                    }
                    count = 1;
                    nowString = substring;
                }
            }

            if (count > 1) {
                temp += count.toString() + nowString;
            } else {
                temp += nowString;
            }
            result = Math.min(result, temp.length());
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.solution(s));
    }
}
