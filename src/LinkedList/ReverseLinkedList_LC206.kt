package LinkedList

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "ListNode(`val`=$`val`, next=$next)"
    }
}

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
    var temp :ListNode? = null
    fun reverseList(head: ListNode?): ListNode? {
        var curr = head
        var prev: ListNode? = null
        if(curr?.next == null)
            return curr
        while(curr != null) {
            var temp = curr?.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        return prev
    }
}