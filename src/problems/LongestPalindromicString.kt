package problems

class LongestPalindromicString {
    fun longestPalindrome(s: String): String {
        var result = ""
        for (i in 0..s.length - 1) {
            var cur1 = i
            var cur2 = i
            while (cur2 + 1 < s.length && s[cur2] == s[cur2 + 1]) {
                cur2++
            }
            if (result.length < cur2 + 1 - cur1) {
                result = s.substring(cur1, cur2 + 1)
            }
            cur1--
            cur2++
            while (0 <= cur1 && cur2 < s.length) {
                if (s[cur1] == s[cur2]) {
                    if (s.substring(cur1, cur2 + 1).length > result.length) {
                        result = s.substring(cur1, cur2 + 1)
                    }
                    cur1--
                    cur2++
                } else {
                    break
                }
            }
        }
        return result
    }
}

fun main() {
    val longestPalindromicString = LongestPalindromicString()
    println(longestPalindromicString.longestPalindrome("babad"))
    println(longestPalindromicString.longestPalindrome("cbbd"))
    println(longestPalindromicString.longestPalindrome("xaabacxcabaaxcabaax"))
}