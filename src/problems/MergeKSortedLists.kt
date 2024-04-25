package problems

import java.util.*

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode> { o1, o2 ->
            o1.`val` - o2.`val`
        }
        val result = ListNode(0)
        var now = result

        lists.forEach {
            if (it != null) {
                pq.add(it)
            }
        }

        while (!pq.isEmpty()) {
            val poll = pq.poll()
            now.next = ListNode(poll.`val`)
            now = now.next!!
            if (poll.next != null) {
                pq.add(poll.next)
            }
        }

        return result.next
    }
}