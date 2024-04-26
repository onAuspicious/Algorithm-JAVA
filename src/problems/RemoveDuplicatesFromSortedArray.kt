package problems

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var now = nums[0]
        var index = 0

        for (i in 0..nums.size - 1) {
            if (nums[i] > now) {
                index++
                nums[index] = nums[i]
                now = nums[i]
            }
        }

        return index + 1
    }
}