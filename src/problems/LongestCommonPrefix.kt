package problems

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val str = strs[0]
        var result = ""
        for (i in 0..str.length - 1) {
            val now = str[i]
            var status = true
            strs.forEach {
                if (i > it.length) {
                    status = false
                    return@forEach
                }

                if (it[i] != now) {
                    status = false
                }
            }
            if (status) {
                result += now
            } else {
                break
            }
        }
        return result
    }
}

fun main() {
    val c = LongestCommonPrefix()
    println(c.longestCommonPrefix(arrayOf("ab", "a")))
}