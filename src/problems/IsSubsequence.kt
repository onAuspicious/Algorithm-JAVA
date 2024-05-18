package problems

class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        var ps = 0
        var pt = 0

        while (pt < t.length && ps < s.length) {
            if (s[ps] == t[pt]) {
                ps++
            }
            pt++
        }

        return s.length == ps
    }
}