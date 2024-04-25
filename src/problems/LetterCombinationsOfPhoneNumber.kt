package problems

class LetterCombinationsOfPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        // create hashMap of digit to List<String>
        val charMap = mapOf(
            '2' to listOf("a", "b", "c"),
            '3' to listOf("d", "e", "f"),
            '4' to listOf("g", "h", "i"),
            '5' to listOf("j", "k", "l"),
            '6' to listOf("m", "n", "o"),
            '7' to listOf("p", "q", "r", "s"),
            '8' to listOf("t", "u", "v"),
            '9' to listOf("w", "x", "y", "z")
        )
        val result = mutableListOf<String>()

        // tracking
        this.tracking(0, digits, "", result, charMap)

        return result
    }

    private fun tracking(cur: Int, digits: String, make: String, result: MutableList<String>, charMap: Map<Char, List<String>>) {
        if (cur == digits.length) {
            if (make != "") {
                result.add(make)
            }
            return
        }

        charMap[digits[cur]]!!.forEach {
            this.tracking(cur + 1, digits, make + it, result, charMap)
        }
    }
}