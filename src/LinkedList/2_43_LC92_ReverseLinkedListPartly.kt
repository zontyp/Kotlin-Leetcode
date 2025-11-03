package LinkedList
/*
LC 92
https://leetcode.com/problems/reverse-linked-list-ii/
Given the head of a singly linked list and two integers
left and right where left <= right, reverse the nodes of the list
from position left to position right, and return the reversed list.
You need to manage 4 moving parts:
idea:

reverse the sub list only
then turn / rotate it to connect to existing list
connect
beforePart: node before the reversed sublist
to
reversedHead: new head of reversed sublist
----------------------------------------------
connect
reversedTail (start of the reversed range)
to
current: where to reconnect the tail
9
 */
class `2_43_LC92_ReverseLinkedListPartly` {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if(head == null || left == right)
            return head
        var dummy = ListNode(0)
        dummy.next = head
        var beforePart:ListNode = dummy
        repeat(left - 1){
            beforePart = beforePart.next!!
        }
//now beforePart is one before left
        //current is at left
        var current = beforePart.next
        var reversedTail = current
        var reversedHead: ListNode? = null
        //start the reversals
        repeat(right - left + 1){
            var temp = current?.next
            current?.next = reversedHead
            reversedHead = current!!
            current = temp
        }
        //connect reversed Head7
        beforePart.next = reversedHead
        //connect reversedTail
        reversedTail?.next = current
        return dummy.next
    }
}