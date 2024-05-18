package problems

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        val mx = intArrayOf(-1, 0, 1, 0)
        val my = intArrayOf(0, -1, 0, 1)
        // 1. create check arr and define result
        val check = Array(grid.size) { BooleanArray(grid[0].size) { false }}
        var result = 0

        // 2. brute force
        for (i in 0..grid.size - 1) {
            for (j in 0..grid[0].size - 1) {
                if (!check[i][j] && grid[i][j] == '1') {
                    val dq = ArrayDeque<Pair<Int, Int>>()
                    dq.addLast(Pair(i, j))
                    check[i][j] = true
                    while (!dq.isEmpty()) {
                        val now = dq.removeFirst()
                        for (i in 0..3) {
                            val nx = now.first + mx[i]
                            val ny = now.second + my[i]
                            if (0 <= nx && nx < grid.size && 0 <= ny && ny < grid[0].size && !check[nx][ny] && grid[nx][ny] == '1') {
                                dq.addLast(Pair(nx, ny))
                                check[nx][ny] = true
                            }
                        }
                    }
                    result++
                }
            }
        }

        return result
    }
}