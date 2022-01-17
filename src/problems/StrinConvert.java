package problems;

public class StrinConvert {

    public static void main(String[] args) {

        String input = "this_is_long_value";
        if (input.contains("_")) {
            changeSnakeToCamel(input);
        } else {
            changeCamelToSnake(input);
        }

    }

    public static String changeCamelToSnake(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) - 'a' < 0) {
                sb.append('_').append(Character.toLowerCase(input.charAt(i)));
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String changeSnakeToCamel(String input) {
        StringBuilder sb = new StringBuilder();
        boolean state = false; // 이전 값이 '_' 인 경우 state = true

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '_') {
                state = true;
                continue;
            }
            if (state) {
                state = false;
                sb.append(Character.toUpperCase(input.charAt(i)));
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
