package problems

import kotlin.math.*

class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        // length is right - left + 1
        var left = 0
        var right = 0
        var sum = nums[0]
        var result = Integer.MAX_VALUE

        while (right < nums.size) {
            if (sum >= target) {
                result = min(result, right - left + 1)
                sum -= nums[left++]
            } else {
                if (right + 1 < nums.size) {
                    sum += nums[++right]
                    continue
                }
                right++
            }
            if (result <= 1) {
                return result
            }
        }

        return if (result == Integer.MAX_VALUE) {
            0
        } else {
            result
        }
    }
}