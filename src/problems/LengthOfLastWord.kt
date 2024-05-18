package problems

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        var cnt = 0
        var space = true

        for (i in 0..s.length - 1) {
            if (s[i] == ' ') {
                space = true
                continue
            }
            if (space && s[i].isLetter()) {
                cnt = 1
                space = false
                continue
            }
            if (!space && s[i].isLetter()) {
                cnt++
            }
        }
        return cnt
    }
}