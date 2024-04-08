package problems

import java.util.Stack

class SearchAfterBigNumber {
    fun solution(numbers: IntArray): IntArray {
        val stack = Stack<Pair<Int, Int>>()
        val result = IntArray(numbers.size)

        for (i in 0..numbers.size - 1) {
            while (stack.isNotEmpty() && stack.last().second < numbers[i]) {
                val pop = stack.pop()
                result[pop.first] = numbers[i]
            }
            stack.push(Pair(i, numbers[i]))
        }

        while (stack.isNotEmpty()) {
            result[stack.pop().first] = -1
        }

        return result
    }
}

fun main() {
    val searchAfterBigNumber = SearchAfterBigNumber()
    searchAfterBigNumber.solution(intArrayOf(2, 3, 3, 5))
}