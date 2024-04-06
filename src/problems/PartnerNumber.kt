package problems

import kotlin.math.min

class PartnerNumber {
    fun solution(X: String, Y: String): String {
        var result = ""
        val xArr = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        val yArr = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        X.forEach { xArr[it.digitToInt()]++ }
        Y.forEach { yArr[it.digitToInt()]++ }

        for (i in 9 downTo 0) {
            val cnt = min(xArr[i], yArr[i])
            result += i.toString().repeat(cnt)
        }

        return if (result == "") {
            "-1"
        } else if (result.any { it != '0' }) {
            result
        } else {
            "0"
        }
    }
}

fun main() {
    val partnerNumber = PartnerNumber()
    println(partnerNumber.solution("100", "2345"))
    println(partnerNumber.solution("100", "203045"))
    println(partnerNumber.solution("100", "123450"))
    println(partnerNumber.solution("12321", "42531"))
    println(partnerNumber.solution("5525", "1255"))
}