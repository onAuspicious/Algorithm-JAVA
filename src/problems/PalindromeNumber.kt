package problems

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val str = x.toString()
        var l = 0
        var r = str.length - 1

        while (l <= r) {
            if (str[l] != str[r]) {
                return false
            }
            l++
            r--
        }
        return true
    }
}