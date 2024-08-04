package problems;

import java.util.Scanner;

public class Sparta1Java {

    private String[] firstList = {"기철초풍", "멋있는", "재미있는"};
    private String[] secondList = {"도전적인", "노란색의", "바보같은"};
    private String[] thirdList = {"돌고래", "개발자", "오랑우탄"};

    public String createRandomNickname() {
        // 여기에 랜덤으로 닉네임을 만드는 코드를 적어주세요
        String a = "1";
        Scanner scanner = new Scanner(System.in);
        char c = a.charAt(0);
        if (Character.isLetter(c)) {
            System.out.println("this is in a to z");
        }
        return "랜덤으로 생성된 닉네임";
    }

    public static void main(String[] args) {
        Sparta1Java sparta1Java = new Sparta1Java();
        String myNickname = sparta1Java.createRandomNickname();
        System.out.println(myNickname);
    }
}
