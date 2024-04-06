package problems

class ContinuousSubsequenceSum {
    fun solution(sequence: IntArray, k: Int): IntArray {
        // 1. create cursor 'first' and 'last' = 0, create value sum: Int
        var first = 0
        var last = 0
        var sum = sequence[0]
        var result = Pair(0, Int.MAX_VALUE)

        while (last < sequence.size) {
            // 2. when sum of first to last is lower than k -> last + 1 (lte then size), sum += sequence[last]
            if (sum < k) {
                if (last + 1 < sequence.size) {
                    sum += sequence[last + 1]
                }
                last += 1
                continue
            }
            // 3. when sum of first to last is bigger than k -> first + 1 (lte then last), sum -= sequence[first]
            if (sum > k) {
                if (first == last) {
                    if (last + 1 < sequence.size) {
                        sum += sequence[last + 1]
                    }
                    last++
                } else {
                    sum -= sequence[first]
                    first++
                }
                continue
            }
            // 4. when sum of first to last is equal k then save result
            if (sum == k) {
                result = this.makeResult(result, Pair(first, last))
                if (last + 1 < sequence.size) {
                    sum += sequence[last + 1]
                }
                last++
            }
        }

        return intArrayOf(result.first, result.second)
    }

    private fun makeResult(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Pair<Int, Int> {
        if (p1.second - p1.first > p2.second - p2.first) {
            return p2
        }
        return p1
    }
}

fun main() {
    val continuousSubsequenceSum = ContinuousSubsequenceSum()
    val result1 = continuousSubsequenceSum.solution(intArrayOf(1, 2, 3, 4, 5), 7)
    val result2 = continuousSubsequenceSum.solution(intArrayOf(1, 1, 1, 2, 3, 4, 5), 5)
    val result3 = continuousSubsequenceSum.solution(intArrayOf(2, 2, 2, 2, 2), 6)
    println("${result1[0]}, ${result1[1]}")
    println("${result2[0]}, ${result2[1]}")
    println("${result3[0]}, ${result3[1]}")
}