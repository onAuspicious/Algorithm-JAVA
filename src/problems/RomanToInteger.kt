package problems

class RomanToInteger {
    fun romanToInt(s: String): Int {
        var result = 0
        val map = mutableMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )

        var pointer = 0

        while (pointer < s.length) {
            if (pointer + 1 < s.length && map[s[pointer]]!! < map[s[pointer + 1]]!!) {
                result -= map[s[pointer]]!!
            } else {
                result += map[s[pointer]]!!
            }
            pointer++
        }

        return result
    }
}