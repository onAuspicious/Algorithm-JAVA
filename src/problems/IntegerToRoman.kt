package problems

class IntegerToRoman {
    val romans = arrayOf("I", "V", "X", "L", "C", "D", "M")
    fun intToRoman(num: Int): String {
        var result = ""
        var depth = 0
        var num = num

        while (num != 0) {
            result = this.toRoman(num % 10, depth) + result
            depth += 2
            num /= 10
        }

        return result
    }

    private fun toRoman(num: Int, depth: Int): String {
        var result = ""
        if (num < 5) {
            if (num == 4) {
                result += this.romans[depth] + this.romans[depth + 1]
            } else {
                repeat(num) { result += this.romans[depth] }
            }
        } else {
            if (num == 9) {
                result += this.romans[depth] + this.romans[depth + 2]
            } else {
                result += this.romans[depth + 1]
                repeat(num - 5) { result += this.romans[depth]}
            }
        }
        return result
    }
}

fun main() {
    val c = IntegerToRoman()
    println(c.intToRoman(3))
    println(c.intToRoman(58)) //"LVIII"
    println(c.intToRoman(1994)) // MCMXCIV
    println(c.intToRoman(0))
}