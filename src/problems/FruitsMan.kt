package problems

import kotlin.math.min

class FruitsMan {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var result = 0
        var now = 0
        score.sortDescending()

        while (m + now <= score.size) {
            var min = 10
            for (i in now..<now + m) {
                min = min(min, score[i])
            }
            result += min * m
            now += m
        }

        return result
    }
}