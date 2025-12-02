package LinkedList
/*
LC 148
https://leetcode.com/problems/sort-list/description/
Given the head of a linked list, return the list after
sorting it in ascending order.
idea:
find mid of list
split list into two halves - left , right
sort left
sort right
merge the two sorted lists

why to split / cut lists into two ?
to merge them - we need two separate lists

we can sort two - two elements of list and merge them as well - thats iterative merge sort
 */
class LC148_SortList {
    fun getMid(head: ListNode?):ListNode?{
        var s = head
        var f = head
        var prev = head
        while(f != null && f.next != null){
            prev = s
            s = s?.next
            f = f?.next?.next
        }
        prev?.next = null
        return s
    }
    fun merge(left:ListNode?,right:ListNode?):ListNode?{
        var left = left
        var right = right
        var dummy = ListNode(0)
        var current = dummy
        while(left != null && right != null){
            if(left.`val` < right.`val`) {
                current.next = left
                left = left.next
            }
                else {
                    current.next = right
                    right = right.next
            }

            current = current.next!!

            }
            current.next = left?:right
        return dummy.next
        }

    fun sortList(head: ListNode?): ListNode? {
        if(head?.next == null)
            return head
        val mid = getMid(head)
        val left = sortList(head)
        val right = sortList(mid)
        return merge(left,right)
    }



}
fun main() {
    // Helper to create a linked list from an array
    fun createList(arr: IntArray): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        for (num in arr) {
            current.next = ListNode(num)
            current = current.next!!
        }
        return dummy.next
    }

    // Helper to print a linked list
    fun printList(head: ListNode?) {
        var current = head
        while (current != null) {
            print("${current!!.`val`} -> ")
            current = current!!.next
        }
        println("null")
    }

    // Test input
    val arr = intArrayOf(4, 2, 1, 3)
    val head = createList(arr)

    println("Original list:")
    printList(head)

    // Sort the list
    val sorter = LC148_SortList()
    val sortedHead = sorter.sortList(head)

    println("Sorted list:")
    printList(sortedHead)
}