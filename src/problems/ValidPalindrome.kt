package problems

import java.util.*

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1

        while (l < r) {
            if (!s[l].isLetterOrDigit()) {
                l++
                continue
            }
            if (!s[r].isLetterOrDigit()) {
                r--
                continue
            }
            if (s[l].isDigit()) {
                if (s[l] != s[r]) {
                    return false
                }
            }
            if (s[l].isLetter()) {
                if (!s[r].isLetter()) {
                    return false
                }
                if (s[l].lowercase() != s[r].lowercase()) {
                    return false
                }
            }
            l++
            r--
        }

        return true
    }
}