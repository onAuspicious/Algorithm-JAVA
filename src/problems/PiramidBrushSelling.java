package problems;

import java.util.*;

public class PiramidBrushSelling {
    static class Person {
        String name;
        Person parent;
        int money;

        public Person(String name) {
            this.name = name;
            money = 0;
        }
    }

    static HashMap<String, Person> tree = new HashMap<>();
    static int[] money;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        money = new int[enroll.length];

        // 모든 노드들 생성
        tree.put("-", new Person("-"));
        for (int i = 0; i < enroll.length; i++) {
            tree.put(enroll[i], new Person(enroll[i]));
        }

        // 각 노드들의 Parent 노드 연결
        for (int i = 0; i < referral.length; i++) {
            tree.get(enroll[i]).parent = tree.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            addMoney(tree.get(seller[i]), amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            money[i] = tree.get(enroll[i]).money;
        }

        return money;
    }

    public static void addMoney(Person person, int money) {
        int parentMoney = money / 10;
        if (parentMoney != 0 && person.parent != null) {
            addMoney(person.parent, parentMoney);
            person.money += money - parentMoney;
        } else {
            person.money += money;
        }
    }
}
