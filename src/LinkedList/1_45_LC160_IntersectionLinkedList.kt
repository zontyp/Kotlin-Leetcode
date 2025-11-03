package LinkedList

/*
LC160
https://leetcode.com/problems/intersection-of-two-linked-lists/description/

Given the heads of two singly linked-lists headA and headB,
return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.

idea:
Start two pointers at the heads of the two lists.
When one pointer reaches the end of its list, jump to the head of the other list.
If there's an intersection, both pointers will meet at the shared node.
If not, they’ll both become null at the same time.

if there is intersection - we can divide the two lists in 4 parts ATBT
part a before tail , part b before tail , common tail T
so if we traverse ATB
or BTA - then remaining T will start at same point for both ATB , BTA paths

imagine a park with one long straight path
three parts of the lane are there
A,T,B
if man goes ATB
or BTA
he will at end reach same point
if intersection is there - T is common for both lists
if intersection is not there - no common T
so we can use above concept and travel ATB , BTA and see if both nodes are null or at same point
checking currentA == null is important as otherwise the two nodes will never be equal
*/

class LC160_IntersectionLinkedList {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var currentA = headA
        var currentB = headB

        // Traverse both lists. When a pointer reaches the end of one list,
        // redirect it to the head of the other list.
        while (currentA != currentB) {
            currentA = if (currentA == null) headB else currentA.next
            currentB = if (currentB == null) headA else currentB.next
        }

        // Both pointers will either meet at the intersection node or at null
        return currentA
    }
}


fun main() {
    // Shared tail: 8 -> 10
    val shared = ListNode(8).apply {
        next = ListNode(10)
    }

    // First list: 3 -> 7 -> 8 -> 10
    val headA = ListNode(3).apply {
        next = ListNode(7).apply {
            next = shared
        }
    }

    // Second list: 99 -> 1 -> 8 -> 10
    val headB = ListNode(99).apply {
        next = ListNode(1).apply {
            next = shared
        }
    }

    val solution = LC160_IntersectionLinkedList()
    val intersection = solution.getIntersectionNode(headA, headB)

    if (intersection != null) {
        println("Intersection Node Value: ${intersection.`val`}")
    } else {
        println("No intersection")
    }
}
