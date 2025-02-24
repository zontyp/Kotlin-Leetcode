package LinkedList

class RemoveNthNodeTwoPointer {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var first: ListNode? = dummy
        var second: ListNode? = dummy

        // Move `first` ahead by `n + 1` steps
        for (i in 0..n) {
            first = first?.next
        }

        // Move `first` to the end, keeping `second` n steps behind
        while (first != null) {
            first = first.next
            second = second?.next
        }

        // Remove the nth node
        second?.next = second?.next?.next

        return dummy.next
    }

}