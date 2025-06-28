package LinkedList
/*
LC 206
https://leetcode.com/problems/reverse-linked-list/description/
Given the head of a singly linked list, reverse the list,
and return the reversed list.


 */


fun main() {
    val one = ListNode(1)
    val two = ListNode(2)
    val three = ListNode(3)
    val four = ListNode(4)
    one.next = two
    two.next = three
    three.next = four
    val new = ReverseLinkedList_LC206().reverseList(one)
    println(new?.`val`)
    println(new?.next?.`val`)
    println(new?.next?.next?.`val`)
    println(new?.next?.next?.next?.`val`)

}
class ReverseLinkedList_LC206 {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        var curr = head
        var prev: ListNode? = null
        //single node case

        while(curr != null) {
            //cache the next of curr
            var temp = curr?.next
            //reverse the pointer of curr
            curr.next = prev
            //move ahead to reverse the following pointer
            prev = curr
            curr = temp
        }
        return prev
    }
}