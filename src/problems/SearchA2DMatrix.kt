package problems

class SearchA2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var col = 0
        var row = matrix.size - 1
        while (col < matrix[0].size && row >= 0) {
            if (matrix[row][col] == target) {
                return true
            }
            if (matrix[row][col] < target) {
                col++
            } else {
                row--
            }
        }
        return false
    }
}