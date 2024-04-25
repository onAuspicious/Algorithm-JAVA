package problems

class RemoveNthNodeFromEndOfList {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        // get size
        val size = this.getListNodeSize(head!!)
        val removeIndex = size - n

        if (removeIndex == 0) {
            return head!!.next
        }

        // remove
        var idxNow = 1
        var now = head

        while (idxNow < removeIndex) {
            now = now!!.next
            idxNow++
        }

        now!!.next = now!!.next?.next

        return head
    }

    private fun getListNodeSize(node: ListNode): Int {
        var size = 1
        var now = node
        while (now.next != null) {
            size++
            now = now.next!!
        }
        return size
    }
}