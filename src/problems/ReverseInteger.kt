package problems

import kotlin.math.abs

class ReverseInteger {
    fun reverse(x: Int): Int {
        Int.MAX_VALUE
        var result = ""
        val isMinus = x < 0
        var x = x

        while (x != 0) {
            val now = abs(x % 10)
            x /= 10
            if (now == 0 && result == "") {
                continue
            }
            result += now.toString()
        }

        if (result == "") {
            result = "0"
        }

        return if (isMinus) {
            if (Int.MIN_VALUE.toString().length <= result.length + 1 && Int.MIN_VALUE.toString() < "-$result") {
                0
            } else {
                result.toInt() * -1
            }
        } else {
            if (Int.MAX_VALUE.toString().length <= result.length && Int.MAX_VALUE.toString() < result) {
                0
            } else {
                result.toInt()
            }
        }
    }
}

fun main() {
    val c = ReverseInteger()
    println(c.reverse(123))
    println(c.reverse(-123))
    println(c.reverse(Int.MAX_VALUE))
    println(c.reverse(Int.MIN_VALUE))
    println(c.reverse(0))
}