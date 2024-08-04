package problems

class Sparta1 {
    private val firstList = arrayOf("기철초풍", "멋있는", "재미있는")
    private val secondList = arrayOf("도전적인", "노란색의", "바보같은")
    private val thirdList = arrayOf("돌고래", "개발자", "오랑우탄")

    fun createRandomNickname(): String {
        // 여기에 랜덤으로 닉네임을 만드는 코드를 적어주세요

        val a = "a"
        return "랜덤으로 생성된 닉네임"
    }
}

fun main() {
    val sparta1Java = Sparta1Java()
    val myNickname = sparta1Java.createRandomNickname()
    println(myNickname)
}