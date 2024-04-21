package problems

import kotlin.math.*

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var lt = 0
        var rt = height.size - 1
        var result = 0

        while (lt < rt) {
            result = max(result, (rt - lt) * min(height[lt], height[rt]))
            if (height[lt] < height[rt]) {
                lt++
            } else {
                rt--
            }
        }
        return result
    }
}