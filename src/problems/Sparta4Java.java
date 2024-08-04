package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Sparta4Java {
    public static void main(String[] args) {
        String[] rsp = {"바위", "가위", "보"};
        Map<Integer, String> gifts = new HashMap<>();
        gifts.put(0, "꽝");
        gifts.put(1, "곰돌이 인형");
        gifts.put(2, "스파르타 랜드 입장권");
        gifts.put(3, "스파르타 캐니언 항공 투어권");
        gifts.put(4, "호텔 스파르타 숙박권");
        gifts.put(5, "스파르테이트 항공권");

        int cnt = 0;
        int numOfWins = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (cnt < 5) {
            System.out.println("가위 바위 보 중 하나를 입력해주세요!");
            String userInput = scanner.nextLine();

            if (!userInput.equals("바위") && !userInput.equals("가위") && !userInput.equals("보")) {
                System.out.println("잘못된 입력입니다!");
                continue;
            }

            String randomRcp = rsp[random.nextInt(rsp.length)];

            switch (userInput) {
                case "바위":
                    switch (randomRcp) {
                        case "바위":
                            System.out.println("당신의 " + userInput + " 그리고 상대는 " + randomRcp + " 으로 서로 비겼습니다.");
                            break;
                        case "가위":
                            System.out.println("당신의 " + userInput + " 그리고 상대는 " + randomRcp + " 으로 당신이 이겼습니다!");
                            numOfWins++;
                            break;
                        default:
                            System.out.println("당신의 " + userInput + " 그리고 상대는 " + randomRcp + " 으로 당신이 졌습니다..");
                            break;
                    }
                    break;
                case "가위":
                    switch (randomRcp) {
                        case "가위":
                            System.out.println("당신의 " + userInput + " 그리고 상대는 " + randomRcp + " 으로 서로 비겼습니다.");
                            break;
                        case "보":
                            System.out.println("당신의 " + userInput + " 그리고 상대는 " + randomRcp + " 으로 당신이 이겼습니다!");
                            numOfWins++;
                            break;
                        default:
                            System.out.println("당신의 " + userInput + " 그리고 상대는 " + randomRcp + " 으로 당신이 졌습니다..");
                            break;
                    }
                    break;
                case "보":
                    switch (randomRcp) {
                        case "보":
                            System.out.println("당신의 " + userInput + " 그리고 상대는 " + randomRcp + " 으로 서로 비겼습니다.");
                            break;
                        case "바위":
                            System.out.println("당신의 " + userInput + " 그리고 상대는 " + randomRcp + " 으로 당신이 이겼습니다!");
                            numOfWins++;
                            break;
                        default:
                            System.out.println("당신의 " + userInput + " 그리고 상대는 " + randomRcp + " 으로 당신이 졌습니다..");
                            break;
                    }
                    break;
            }
            cnt++;
        }

        System.out.println("축하합니다! 총 " + numOfWins + " 회 승리하여 경품으로 [" + gifts.get(numOfWins) + "] 을 획득하셨습니다!");
    }
}
