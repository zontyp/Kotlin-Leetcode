package LinkedList

// LeetCode 21: Merge Two Sorted Lists
class LC21_MergeTwoSortedList {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var list1 = list1
        var list2 = list2

        // Dummy node to simplify edge case handling
        val dummy = ListNode(0)
        var current = dummy

        // Traverse both lists until one is exhausted
        while (list1 != null && list2 != null) {
            if (list1.`val` <= list2.`val`) {
                // Attach the smaller node to the result list
                current.next = list1
                list1 = list1.next
            } else {
                current.next = list2
                list2 = list2.next
            }
            current = current.next!!  // Advance current
        }

        // Attach the remaining nodes of the non-null list
        current.next = list1 ?: list2

        // Return the head of the merged list
        return dummy.next
    }
}




// Main function to test LC21_MergeTwoSortedList
fun main() {
    // First sorted list: 1 -> 3 -> 5
    val a = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(5)
        }
    }

    // Second sorted list: 2 -> 4 -> 6
    val b = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(6)
        }
    }

    val merged = LC21_MergeTwoSortedList().mergeTwoLists(a, b)

    println("Merged List:")
    printList(merged)  // Expected Output: 1 2 3 4 5 6
}
