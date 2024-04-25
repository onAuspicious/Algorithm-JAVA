package problems

class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        this.recursion(list1, list2, dummy)

        return dummy.next
    }

    private fun recursion(list1: ListNode?, list2: ListNode?, save: ListNode) {
        if (list1 == null && list2 == null) {
            return
        }

        if (list1 == null) {
            val next = ListNode(list2!!.`val`)
            save.next = next
            this.recursion(list1, list2.next, save.next!!)
            return
        }

        if (list2 == null) {
            val next = ListNode(list1.`val`)
            save.next = next
            this.recursion(list1.next, list2, save.next!!)
            return
        }

        if (list1.`val` < list2.`val`) {
            val next = ListNode(list1.`val`)
            save.next = next
            this.recursion(list1.next, list2, save.next!!)
        } else {
            val next = ListNode(list2.`val`)
            save.next = next
            this.recursion(list1, list2.next, save.next!!)
        }
    }
}