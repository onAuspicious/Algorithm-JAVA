package problems

class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        val save = ListNode(0)
        var dummy = save // save dummy
        var now = head

        while (now != null) {
            val first = now
            val second = now.next // nullable

            dummy = this.connect(first, second, dummy)
            now = now.next?.next
        }

        return save.next
    }

    private fun connect(first: ListNode, second: ListNode?, save: ListNode): ListNode {
        var now = save
        if (second == null) {
            now.next = ListNode(first.`val`)
            return now.next!!
        }
        now.next = ListNode(second!!.`val`)
        now = now.next!!
        now.next = ListNode(first.`val`)
        return now.next!!
    }
}