package problems

import java.util.*

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val openBrackets = setOf('(', '{', '[')
        val closeMap = mapOf(
            '}' to '{',
            ')' to '(',
            ']' to '['
        )
        val stack = Stack<Char>()

        s.forEach {
            if (openBrackets.contains(it)) {
                stack.push(it)
            } else {
                if (stack.isNotEmpty() && closeMap[it] == stack.peek()) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}