package LinkedList

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

class RecursiveReverseLinkList {
    fun reverseList(head: ListNode?): ListNode? {
        var newHead = head
        if(head?.next != null)
        {
          reverseList(head?.next)
            head?.next?.next = head
        }
        head?.next = null
        return newHead
    }
}