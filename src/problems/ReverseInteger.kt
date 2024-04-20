package problems

import kotlin.math.abs

class ReverseInteger {
    fun reverse(x: Int): Int {
        var result = 0
        var isMinus = x < 0
        var absX = abs(x)

        while (absX > 0) {
            val mod = absX % 10
            absX = absX / 10
            result = result * 10 + mod
        }

        return if (isMinus) {
            result * - 1
        } else {
            result
        }
    }
}