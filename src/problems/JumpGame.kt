package problems

import java.util.*

class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var end = nums.size - 1
        var check = BooleanArray(nums.size) { false }

        check[0] = true
        var q = ArrayDeque<Int>()
        q.addLast(0)
        while (!q.isEmpty()) {
            val now = q.removeFirst()

            for (i in 0..nums[now]) {
                if (now + i > end) {
                    break
                }
                if (now + i <= end && !check[now + i]) {
                    check[i + now] = true
                    q.addLast(now + i)
                    if (check[end]) {
                        return true
                    }
                }
            }
        }

        return check[end]
    }
}