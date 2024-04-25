package problems

class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        this.tracking(0, 0, n, "", result)
        return result
    }

    // open >= close, open & close <= n
    // if open && close == n add result List<String>
    private fun tracking(op: Int, cl: Int, n: Int, now: String, result: MutableList<String>) {
        if (op == n && cl == n) {
            result.add(now)
            return
        }

        if (op < n) {
            this.tracking(op + 1, cl, n, "$now(", result)
        }

        if (cl < op) {
            this.tracking(op, cl + 1, n, "$now)", result)
        }
    }
}