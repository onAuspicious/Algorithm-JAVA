package problems

class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        val save = Array(numRows) { "" }
        var result = ""
        var dest = true // true: up, false: down
        var now = 0

        if (numRows == 1) {
            return s
        }

        for (i in 0..s.length - 1) {
            save[now] = save[now] + s[i]
            if (dest) {
                if (now + 1 < numRows) {
                    now++
                } else {
                    dest = false
                    now--
                }
            } else {
                if (now - 1 >= 0) {
                    now--
                } else {
                    dest = true
                    now++
                }
            }
        }
        save.forEach { result += it }
        return result
    }
}

fun main() {
    val c = ZigzagConversion()
    println(c.convert("PAYPALISHIRING", 3))
    println(c.convert("PAYPALISHIRING", 4))
    println(c.convert("PAYPALISHIRING", 1))
    println(c.convert("PAYPALISHIRING", 2))
}