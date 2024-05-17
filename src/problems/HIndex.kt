package problems

class HIndex {
    fun hIndex(citations: IntArray): Int {
        citations.sortDescending()
        var result = 0
        for (i in 0..citations.size - 1) {
            if (i + 1 <= citations[i]) {
                result = i + 1
            }
        }
        return result
    }
}