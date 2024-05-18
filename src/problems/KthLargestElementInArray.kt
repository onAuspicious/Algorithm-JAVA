package problems

import java.util.*

class KthLargestElementInArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // 1. create priority queue
        val pq = PriorityQueue<Int>() {
                o1, o2 -> o2 - o1
        }
        // 2. insert nums values
        nums.forEach {
            pq.add(it)
        }
        // 3. pop k times at k is result of solution
        var now = 0
        var result = 0
        while (now < k) {
            result = pq.poll()!!
            now++
        }
        return result
    }
}