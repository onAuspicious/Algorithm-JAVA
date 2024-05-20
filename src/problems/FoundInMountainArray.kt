package problems

class FoundInMountainArray {
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        // 1. find highest index by binary search
        var lt = 0
        var rt = mountainArr.length() - 1
        var high = -1

        while (true) {
            var mid = (lt + rt) / 2
            if (mid == 0) mid++
            if (mid == mountainArr.length() - 1) mid--
            if (0 < mid && mid < mountainArr.length()  - 1 && mountainArr.get(mid - 1) > mountainArr.get(mid)) {
                rt = mid - 1
            }
            if (0 < mid && mid < mountainArr.length()  - 1 && mountainArr.get(mid + 1) > mountainArr.get(mid)) {
                lt = mid + 1
            }
            if (0 < mid && mid < mountainArr.length()  - 1 && mountainArr.get(mid - 1) < mountainArr.get(mid) && mountainArr.get(mid + 1) < mountainArr.get(mid)) {
                high = mid
                break
            }
        }
        // 2. if higest index is not target
        if (mountainArr.get(high) == target) {
            return high
        }
        // 3. find to left side by binary search
        lt = 0
        rt = high
        while (lt <= rt) {
            val mid = (lt + rt) / 2
            if (mid < 0 || mid > high) {
                break
            }
            if (mountainArr.get(mid) < target) {
                lt = mid + 1
            } else if (mountainArr.get(mid) > target) {
                rt = mid - 1
            } else {
                return mid
            }
        }
        // 4. if can't find left side then to the right binary search
        lt = high
        rt = mountainArr.length() - 1
        while (lt <= rt) {
            val mid = (lt + rt) / 2
            if (mid >= mountainArr.length() || mid < high) {
                break
            }
            if (mountainArr.get(mid) < target) {
                rt = mid - 1
            } else if (mountainArr.get(mid) > target) {
                lt = mid + 1
            } else {
                return mid
            }
        }

        // 5. can't find target => return -1
        return -1
    }
}

class MountainArray(
    val size: Int,
) {

    val arr = IntArray(size) { 0 }
    fun get(index: Int): Int {
        return arr[index]
    }
    fun length(): Int {
        return arr.size
    }
 }