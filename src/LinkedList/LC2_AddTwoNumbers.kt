package LinkedList

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

class LC2_AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2
        var carry = 0
        val dummyHead = ListNode(0) // Dummy node to simplify result list construction
        var current = dummyHead     // Pointer to build the new list

        // Traverse both lists
        while (l1 != null || l2 != null) {
            val l1Val = l1?.`val` ?: 0  // Take value or 0 if null
            val l2Val = l2?.`val` ?: 0
            var sum = carry + l1Val + l2Val
            carry = sum / 10               // Update carry
            sum = sum % 10                 // Value for the current node
            current.next = ListNode(sum)   // Create new node and attach
            current = current.next!!       // Move current pointer

            l1 = l1?.next
            l2 = l2?.next
        }

        // Handle remaining carry
        if (carry > 0) {
            current.next = ListNode(carry)
        }

        return dummyHead.next
    }
}


// Main function to test the logic
fun main() {
    // (2 -> 4 -> 3) + (5 -> 6 -> 4) = 807 => 7 -> 0 -> 8
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }

    val l2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    val result = LC2_AddTwoNumbers().addTwoNumbers(l1, l2)
    println("Sum: $result") // Output: Sum: 7 -> 0 -> 8
}
