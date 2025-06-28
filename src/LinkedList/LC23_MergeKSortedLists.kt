package LinkedList
/*
LC 23
https://leetcode.com/problems/merge-k-sorted-lists/
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

idea:
we need to add minimum node to result list
priority queue gives us the minimum node.

once we add a node to priority queue - we need to add that nodes next to priority queue as well

 */
import java.util.PriorityQueue

// Class that merges k sorted linked lists
class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        // Min-heap to keep track of the smallest current node among all lists
        val minHeap = PriorityQueue<ListNode>(compareBy { it.`val` })

        // Add the head of each non-null list to the heap
        for (node in lists) {
            if (node != null) {
                minHeap.offer(node)
            }
        }

        // Dummy node to start the merged list
        val dummy = ListNode(0)
        var curr = dummy

        // Continue while the heap has nodes
        while (minHeap.isNotEmpty()) {
            // Take the smallest node from the heap
            val node = minHeap.poll()

            // Append it to the result list
            curr.next = node

            // Move the current pointer forward
            curr = curr.next!!

            // If this node has a next, add it to the heap
            if (node.next != null) {
                minHeap.offer(node.next)
            }
        }

        // Return the head of the merged list (skipping dummy)
        return dummy.next
    }
}



// Main function to test the merging
fun main() {
    // First list: 1 → 4 → 5
    val l1 = ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(5)
        }
    }

    // Second list: 1 → 3 → 4
    val l2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4)
        }
    }

    // Third list: 2 → 6
    val l3 = ListNode(2).apply {
        next = ListNode(6)
    }

    val lists:Array<ListNode?> = arrayOf(l1, l2, l3)

    // Merge the k sorted lists
    val merged = MergeKSortedLists().mergeKLists(lists)

    // Print the result: expected output → 1 1 2 3 4 4 5 6
    printList(merged)
}
