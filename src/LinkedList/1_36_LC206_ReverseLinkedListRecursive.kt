package LinkedList

/*
https://leetcode.com/problems/reverse-linked-list/
Given the head of a singly linked list, reverse the list, and return the reversed list.

idea:
we are at a node head
we pass head.next to recusion
when last  node arrives inside recursion - we return it as the new
head down the call stack
for current head - we just need to form new correct link :
    head.next!!.next = head
    and delete previous link
    head.next = null
 */
class LC206_ReverseLinkedListRecursive {
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null)
        // return the last node
            return head

        // pass next node to recursion to reverse next nodes
        // return the last node at each call to propagate down the call stack
        val newHead = reverseList(head.next)

        // form the new correct link
        // we know head.next exists so we can do head.next!!
        head.next!!.next = head

        // remove existing link
        head.next = null

        // return the last node as it's the new head
        return newHead
    }
}

// Basic ListNode class
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// Utility to print the list
fun printList(head: ListNode?) {
    var curr = head
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next
    }
    println()
}

// Main function to test the recursive reverse
fun main() {
    val one = ListNode(1)
    val two = ListNode(2)
    val three = ListNode(3)
    val four = ListNode(4)
    val five = ListNode(5)
    one.next = two
    two.next = three
    three.next = four
    four.next = five

    println("Original list:")
    printList(one)

    val reversed = LC206_ReverseLinkedListRecursive().reverseList(one)

    println("Reversed list:")
    printList(reversed)
}
