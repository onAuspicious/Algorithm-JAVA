package problems;

public class ElectroMoney {

    public int solution(int[][] fees, int usage) {
        int amount = 0;
        int base = 0; // 기본 요금
        int beforeBaseMoney = 0;

        for (int i = 0; i < fees.length - 1; i++) {
            if (usage > fees[i][0]) {
                amount += (fees[i][0] - beforeBaseMoney) * fees[i][2];
            } else {
                amount += (usage - beforeBaseMoney) * fees[i][2];
                base = fees[i][1];
                break;
            }
            beforeBaseMoney = fees[i][0];
        }

        // 기본 요금이 있으면 추가 후 리턴, 없으면 마지막 까지 기본요금이 없으므로 계산해서 리턴
        if (base == 0) {
            amount += fees[fees.length - 1][1];
            amount += (usage - beforeBaseMoney) * fees[fees.length - 1][2];
        } else {
            amount += base;
        }

        return amount;
    }
}
