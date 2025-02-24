package LinkedList

fun main() {
    val one = ListNode(1)
    val two = ListNode(2)
    val three = ListNode(3)
    val four = ListNode(4)
    val five = ListNode(5)
    one.next = two
    two.next = null
    RemoveNthNode().removeNthFromEnd(one,1)
}
var cnt = 0

class RemoveNthNode {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode?{
        if(head == null)
            return null
        head.next = removeNthFromEnd(head.next,n)
        cnt++
        println(cnt)
        println(head.`val`)
        if(cnt == n){
            return head.next
        }
        return head

    }
}