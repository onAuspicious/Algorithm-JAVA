package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sparta2Java {
    private static Map<String, Integer> beverages = Map.of(
            "사이다", 1700,
            "콜라", 1900,
            "식혜", 2500,
            "솔의눈", 3000
    );

    public void printBeverages() {
        for (Map.Entry<String, Integer> beverage : beverages.entrySet()) {
            System.out.println(beverage.getKey());
        }
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

    }

    public void inputByScanner() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int coin = scanner.nextInt();
        System.out.println(coin);

        System.out.println(beverages.get("콜라"));
        System.out.println(beverages.get("사이다"));
        System.out.println(beverages.get("식혜"));

        String userChoice = "콜라";
        System.out.println(beverages.get(userChoice));

        if (coin < beverages.get(userChoice)) {
            // 실행 종료하기
            System.out.println("돈이 부족합니다");
        } else {
            // 돈이 충분할 경우
            System.out.println("asdf");
        }

        /*
        * println(beverages["콜라"])
        println(beverages["사이다"])
        println(beverages["식혜"])

        val userChoice = "콜라"
        println(beverages[userChoice])

        if (coin < beverages[userChoice]!!) {
            // 실행 종료하기
            println("돈이 부족합니다")
        } else {
            // 돈이 충분할 경우
        }
        * */
    }

    public void printBeveragesKeys() {
        System.out.println(beverages.keySet());
    }

    public void calc(String userChoice) {
        if (beverages.containsKey(userChoice)) {

        }
    }

    public static void main(String[] args) {
        System.out.println(beverages.keySet());
    }
}


