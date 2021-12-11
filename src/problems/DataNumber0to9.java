package problems;

public class DataNumber0to9 {
    // 위에서부터 아래로
//    String[] numbersLeft = new String[]{
//            "11111", "10001", "10111", "10101", "11100", "11101", "11111", "11000", "11111", "11101"
//    };
//    String[] numbersMid = new String[]{
//            "10001", "11111", "10101", "10101", "00100", "10101", "10101", "10000", "10101", "10101"
//    };
//    String[] numbersRight = new String[]{
//            "11111", "00001", "11101", "11111", "11111", "10111", "10111", "11111", "11111", "11111"
//    };

    String[][] numbers = new String[][]{
            {"11111", "10001", "10111", "10101", "11100", "11101", "11111", "11000", "11111", "11101"},
            {"10001", "11111", "10101", "10101", "00100", "10101", "10101", "10000", "10101", "10101"},
            {"11111", "00001", "11101", "11111", "11111", "10111", "10111", "11111", "11111", "11111"}
    };

    public String solution(String[] pixels) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < pixels[0].length(); i += 3) {
            int number = pixelCheck(pixels, i);
            result.append(number);
        }

        return result.toString();
    }

    public int pixelCheck(String[] pixels, int start) {
        boolean state;

        for (int i = 0; i < 10; i++) {
            state = true;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    if (pixels[k].charAt(start + j) != numbers[j][i].charAt(k)) {
                        state = false;
                        break;
                    }
                }
                if (!state) break;
            }
            if (state){
                return i;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        DataNumber0to9 line3 = new DataNumber0to9();
        String r = line3.solution(new String[]{"111111111111111111111111110111111111", "001101001101101100101101010101001100", "111101111101101111101111010111111111", "100101100101101101101001010101001001", "111111111111111111111111111111111111"});
        System.out.println(r);

    }
}
