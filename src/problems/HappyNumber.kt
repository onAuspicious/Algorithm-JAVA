package problems

class HappyNumber {
    fun isHappy(n: Int): Boolean {
        val map = mutableSetOf(n)
        var now = n
        while (now != 1) {
            val str = now.toString()
            var new = 0
            str.forEach {
                val num = it.toString().toInt()
                new += num * num
            }
            if (map.contains(new)) {
                return false
            }
            map.add(new)
            now = new
        }

        return true
    }
}