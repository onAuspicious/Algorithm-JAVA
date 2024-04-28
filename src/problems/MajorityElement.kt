package problems

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        var now = Now(0, 0)

        for (i in 0..nums.size - 1) {
            if (now.cnt == 0) {
                now.num = nums[i]
                now.cnt++
            } else {
                if (now.num == nums[i]) {
                    now.cnt++
                } else {
                    now.cnt--
                }
            }
        }

        return now.num
    }
}

data class Now(
    var num: Int,
    var cnt: Int,
)