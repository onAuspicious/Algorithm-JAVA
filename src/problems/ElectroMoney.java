package problems;

public class ElectroMoney {

    public int solution(int[][] fees, int usage) {
        int amount = 0;
        int base = 0; // 기본 요금
        int beforeBaseUse = 0; // 이전 구간

        for (int i = 0; i < fees.length - 1; i++) {
            if (usage > fees[i][0]) {
                amount += (fees[i][0] - beforeBaseUse) * fees[i][2];
            } else {
                amount += (usage - beforeBaseUse) * fees[i][2];
                base = fees[i][1];
                break;
            }
            beforeBaseUse = fees[i][0];
        }

        // 기본 요금이 있으면 추가 후 리턴, 없으면 마지막 까지 기본요금이 없으므로 계산해서 리턴
        if (base == 0) {
            amount += fees[fees.length - 1][1];
            amount += (usage - beforeBaseUse) * fees[fees.length - 1][2];
        } else {
            amount += base;
        }

        return amount;
    }
}
