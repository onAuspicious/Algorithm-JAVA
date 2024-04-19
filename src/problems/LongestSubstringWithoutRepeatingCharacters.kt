package problems

import kotlin.math.max

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        // 1. create queue and hashSet and result
        val queue = ArrayDeque<Char>()
        val set = mutableSetOf<Char>() // key: Char, val:
        var result = 0

        s.forEach {
            // 2. poll while hashSet contains current value
            while (set.contains(it)) {
                val removed = queue.removeFirst()
                set.remove(removed)
            }
            // 3. enqueue when hashSet not contains current value and save maximum result
            queue.addLast(it)
            set.add(it)
            result = max(result, set.size)
        }

        // 4. return longest substring size
        return result
    }
}

fun main() {
    val c = LongestSubstringWithoutRepeatingCharacters()
    println(c.lengthOfLongestSubstring("bbbbb"))
    println(c.lengthOfLongestSubstring("abcabcbb"))
    println(c.lengthOfLongestSubstring("pwwkew"))
}