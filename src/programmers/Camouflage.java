package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Camouflage {

    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> clothesHash = new HashMap<>();
        int result = 1;

        for (String[] clothe : clothes) {
            if (clothesHash.containsKey(clothe[1])) {
                ArrayList<String> temp = clothesHash.get(clothe[1]);
                temp.add(clothe[0]);
                clothesHash.replace(clothe[1], temp);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(clothe[0]);
                clothesHash.put(clothe[1], temp);
            }
        }

        for (String c : clothesHash.keySet()) {
            result *= (clothesHash.get(c).size() + 1);
        }
        return result - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Camouflage camouflage = new Camouflage();
        System.out.println(camouflage.solution(clothes));
    }
}
