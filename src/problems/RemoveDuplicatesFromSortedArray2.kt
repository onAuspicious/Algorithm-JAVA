package problems

class RemoveDuplicatesFromSortedArray2 {
    fun removeDuplicates(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var idx = 0

        for (i in 0..nums.size - 1) {
            val now = nums[i]
            if (!map.containsKey(now)) {
                map[now] = 1
                nums[idx++] = now
            } else {
                if (map[now]!! == 2) {
                    continue
                }
                map[now] = 2
                nums[idx++] = now
            }
        }

        return idx
    }
}