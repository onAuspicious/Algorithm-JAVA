package problems

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        val save = IntArray(n + 2) { 0 }
        save[0] = 1

        for (i in 0..n - 1) {
            save[i + 1] = save[i + 1] + save[i]
            save[i + 2] = save[i + 2] + save[i]
        }

        return save[n]
    }
}