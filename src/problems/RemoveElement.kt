package problems

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var idx = 0

        for (i in 0..nums.size - 1) {
            if (`val` == nums[i]) {
                continue
            }
            nums[idx++] = nums[i]
        }

        return idx
    }
}