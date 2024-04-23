package problems

import java.util.Arrays

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val set = mutableSetOf<Triple<Int, Int, Int>>()

        for (i in 0..nums.size - 3) {
            for (j in i + 1..nums.size - 2) {
                val find = this.binarySearch(nums, j + 1, nums.size - 1, 0 - nums[i] - nums[j])
                if (find > 0) {
                    set.add(Triple(nums[i], nums[j], nums[find]))
                }
            }
        }

        return set.toList().map {
            listOf(it.first, it.second, it.third)
        }
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, find: Int): Int {
        var start = start
        var end = end

        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] == find) {
                return mid
            }
            if (nums[mid] < find) {
                start = mid + 1
            }
            if (nums[mid] > find) {
                end = mid - 1
            }
        }
        return -1
    }
}

fun main() {
    val c = ThreeSum()
    println(c.threeSum(intArrayOf(-1,0,1,2,-1,-4)))
    println(c.threeSum(intArrayOf(0,1,1)))
    println(c.threeSum(intArrayOf(0,0,0)))
}