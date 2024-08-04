package problems

class Sparta4 {
}

fun main() {
    val rsp = arrayOf("바위", "가위", "보")
    val gifts = mapOf(
        0 to "꽝",
        1 to "곰돌이 인형",
        2 to "스파르타 랜드 입장권",
        3 to "스파르타 캐니언 항공 투어권",
        4 to "호텔 스파르타 숙박권",
        5 to "스파르테이트 항공권"
    )
    var cnt = 0
    var numOfWins = 0

    while (cnt < 5) {
        println("가위 바위 보 중 하나를 입력해주세요!")
        val userInput = readln()

        if (!rsp.contains(userInput)) {
            println("잘못된 입력입니다!")
            continue
        }

        val randomRcp = rsp.random()

        if (userInput == "바위") {
            when (randomRcp) {
                "바위" -> {
                    println("당신의 $userInput 그리고 상대는 $randomRcp 으로 서로 비겼습니다.")
                }

                "가위" -> {
                    println("당신의 $userInput 그리고 상대는 $randomRcp 으로 당신이 이겼습니다!")
                    numOfWins++
                }

                else -> {
                    println("당신의 $userInput 그리고 상대는 $randomRcp 으로 당신이 졌습니다..")
                }
            }
        }
        if (userInput == "가위") {
            when (randomRcp) {
                "가위" -> {
                    println("당신의 $userInput 그리고 상대는 $randomRcp 으로 서로 비겼습니다.")
                }

                "보" -> {
                    println("당신의 $userInput 그리고 상대는 $randomRcp 으로 당신이 이겼습니다!")
                    numOfWins++
                }

                else -> {
                    println("당신의 $userInput 그리고 상대는 $randomRcp 으로 당신이 졌습니다..")
                }
            }
        }
        if (userInput == "보") {
            when (randomRcp) {
                "보" -> {
                    println("당신의 $userInput 그리고 상대는 $randomRcp 으로 서로 비겼습니다.")
                }

                "바위" -> {
                    println("당신의 $userInput 그리고 상대는 $randomRcp 으로 당신이 이겼습니다!")
                    numOfWins++
                }

                else -> {
                    println("당신의 $userInput 그리고 상대는 $randomRcp 으로 당신이 졌습니다..")
                }
            }
        }
        cnt++
    }

    println("축하합니다! 총 $numOfWins 회 승리하여 경품으로 [${gifts[numOfWins]}] 을 획득하셨습니다!")
}