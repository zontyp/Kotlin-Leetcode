package LinkedList
/*
LC 143
https://leetcode.com/problems/reorder-list/description/
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

idea:
split the list into first half , second half
reverse the secondhalf
merge firstHalf , reversedSecondHalf
 */
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
    LC143_ReorderList().reorderList(one)
}
class LC143_ReorderList {
    fun reverseList(head: ListNode?):ListNode?{
        var prev:ListNode? = null
        var curr = head
        while(curr != null){
            //cache next of curr
            val tempCacheNext = curr.next
            curr.next = prev
            prev = curr
            curr = tempCacheNext
        }
        return prev
    }
    fun reorderList(head: ListNode?) {
        if(head?.next == null)
            return
        var fast = head
        var slow = head
        while(fast?.next!= null){
            slow = slow?.next
            fast = fast.next?.next
        }
        //slow pointer now points to the middle node
        println(slow?.`val`)
        //slow?.next is start of second half - one after the midpoint
        var s = reverseList(slow?.next)
        var f = head
        slow?.next = null
        //mergeListStarts

        //s is always smaller than f so no need to check if f is null
        while(s!=null){
            val fTemp = f?.next
            val sTemp = s?.next
            f?.next = s
            s?.next = fTemp
            s = sTemp
            f = fTemp

        }


    }

}