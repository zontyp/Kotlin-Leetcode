package LinkedList

/*
LC19
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
Given the head of a linked list,
remove the nth node from the end of the list
and return its head.

idea:
two pointers
first pointer need to travel total of n + 1 + x nodes to reach null
second pointer needs to travel x nodes to be able to remove the nth node
if second pointer will travel x nodes - it will reach one before the nth node to remove it
so we make first pointer travel n + 1 nodes
then we start second pointer
when first pointer reaches null
second pointer has travelled x nodes - 1 before n
*/

class LC19_RemoveNthNodeTwoPointer {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var first: ListNode? = dummy
        var second: ListNode? = dummy

        // Move `first` ahead by `n + 1` steps so there's a gap of n nodes
        for (i in 0..n) {
            first = first?.next
        }

        // Move both pointers until `first` reaches the end
        while (first != null) {
            first = first.next
            second = second?.next
        }

        // Skip the node to be deleted
        second?.next = second?.next?.next

        return dummy.next
    }
}

// Definition for singly-linked list.
//class ListNode(var `val`: Int) {
//    var next: ListNode? = null
//}

// Main function to test the implementation
fun main() {
    // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

    val solution = LC19_RemoveNthNodeTwoPointer()
    val newHead = solution.removeNthFromEnd(head, 2) // remove 2nd node from end (i.e., node with value 4)

    // Print resulting linked list
    var current = newHead
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
}
