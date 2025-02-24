package LinkedList

import java.util.PriorityQueue

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.isEmpty())
            return null
        val minHeap = PriorityQueue<ListNode>(compareBy{it.`val`})
        lists.forEach { it?.apply{minHeap.offer(this)} }
        val res = ListNode(0)
        var curr = res
        while(minHeap.isNotEmpty()) {
            curr.next = minHeap.poll().apply{next?.let{minHeap.offer(it)}}
            curr = curr.next!!
        }
        return res.next
    }

}