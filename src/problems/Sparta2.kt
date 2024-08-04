package problems

class Sparta2 {
    val beverages = mapOf(
        "사이다" to 1700,
        "콜라" to 1900,
        "식혜" to 2500,
        "솔의눈" to 3000
    )

    fun printBeverages() {
        for (beverage in beverages) {
            // 여기에 println 문을 적어주세요
            println(beverage.key)
        }
    }

    fun inputBeverage() {
        val input = readlnOrNull()
        println(input)
        val coin = readln().toInt()

        println(beverages["콜라"])
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
    }

    fun printBeveragesKeys() {
        print(beverages.keys)
    }

    fun calc(userChoice: String) {
        if (beverages.containsKey(userChoice)) {

        }
    }
}

fun main() {
    val s = Sparta2()
    s.printBeveragesKeys()


}