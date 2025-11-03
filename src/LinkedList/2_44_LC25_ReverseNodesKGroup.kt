package LinkedList
/*
LC 25
https://leetcode.com/problems/reverse-nodes-in-k-group/description/
Given the head of a linked list, reverse the nodes of the list k at a time,
and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end,
should remain as it is.

You may not alter the values in the list's nodes,
only nodes themselves may be changed.

idea:
we need to reverse k nodes repeatedly
so how many times will we need to reverse ?
totalNodes / k times
instead of calculating total nodes with one full pass
we jump to the kth node
and start reversing from current node to kth node
how will we know what is current node
we keep a groupPrev node
groupPrev points to one before the start node / current node
then after reversing we do current = groupPrev.next
after reversing we do groupPrev.next = kth node to connect the new head to the previous node
 */
class LC25_ReverseNodesKGroup {
    fun getKthNode(startNode:ListNode?,k:Int):ListNode?{
        var current = startNode
        var jumpCount = 1
        while(current != null && jumpCount < k){
            current = current.next
            jumpCount++
        }
        if(jumpCount == k)
            return current
        else
            return null
    }
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var dummy = ListNode(0)
        dummy.next = head
        var groupPrev = dummy
        while(true){
            val kthNode = getKthNode(groupPrev.next,k)
            if(kthNode == null)
                break
            //connect first node of new group to next of k
            //first node of new group is curr which will be
            //assigned to next of k (prev initial value)
            var prev = kthNode.next

             // first node of current group will be connected to group next
            var current = groupPrev.next

            while(current != kthNode.next ) {
                var temp = current?.next
                current?.next = prev
                prev = current
                current = temp
            }
            //temp is at groupNext
            //current is at groupNext
            //prev = kth
            //now just connecct head , tail of reversed to groupPrev
            val reversedTail = groupPrev.next //tail of reverssed is cached
            groupPrev.next  = kthNode //connect reversed Head to dummy / groupPrev
            groupPrev = reversedTail!!
        }
        return dummy.next
    }
}
fun main() {
    // Helper function to create a linked list from list of integers
    fun createLinkedList(values: List<Int>): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        for (value in values) {
            current.next = ListNode(value)
            current = current.next!!
        }
        return dummy.next
    }

    // Helper function to print the linked list
    fun printLinkedList(head: ListNode?) {
        var current = head
        while (current != null) {
            print("${current!!.`val`} -> ")
            current = current!!.next
        }
        println("null")
    }

    // Sample input
    val values = listOf(1, 2, 3, 4, 5)
    val k = 2
    val head = createLinkedList(values)

    println("Original list:")
    printLinkedList(head)

    val solution = LC25_ReverseNodesKGroup()
    val newHead = solution.reverseKGroup(head, k)

    println("List after reversing in k=$k groups:")
    printLinkedList(newHead)
}
