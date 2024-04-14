package problems

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result = ListNode(0)
        this.recursive(l1, l2, result, 0)
        return result
    }

    private fun recursive(n1: ListNode?, n2: ListNode?, result: ListNode?, temp: Int) {
        if (n1 == null && n2 == null || result == null) {
            return
        }

        val tmp = this.getTemp(n1?.`val` ?: 0, n2?.`val` ?: 0, temp)

        if (n1 == null && n2 != null) {
            result.`val` = tmp.second
            result.next = this.createNext(n1, n2, tmp.first)
            this.recursive(n1, n2.next, result.next, tmp.first)
        }

        if (n1 != null && n2 == null) {
            result.`val` = tmp.second
            result.next = this.createNext(n1, n2, tmp.first)
            this.recursive(n1.next, n2, result.next, tmp.first)
        }

        if (n1 != null && n2 != null) {
            result.`val` = tmp.second
            result.next = this.createNext(n1, n2, tmp.first)
            this.recursive(n1.next, n2.next, result.next, tmp.first)
        }
    }

    private fun getTemp(num1: Int, num2: Int, tmp: Int): Pair<Int, Int> {
        val num = num1 + num2 + tmp
        if (num >= 10) {
            return Pair(1, num - 10)
        }
        return Pair(0, num)
    }

    private fun createNext(n1: ListNode?, n2: ListNode?, tmp: Int): ListNode? {
        if (n1?.next == null && n2?.next == null) {
            if (tmp == 1) {
                return ListNode(1)
            }
            return null
        }
        return ListNode(0)
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}