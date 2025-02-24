package LinkedList

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
    ReorderLinkList().reorderList(one)
}
class ReorderLinkList {
    fun reorderList(head: ListNode?) {
        if(head?.next == null)
            return
        var slow = head
        var fast = head
        var slowPrev:ListNode? = null
        while(fast?.next != null){
            slowPrev = slow
            slow = slow?.next
            fast = fast?.next?.next
        }
        slowPrev?.next = null
        var prev:ListNode? = null

        var curr = slow
        while(curr!=null){
            var temp = curr?.next
            curr.next = prev
            prev = curr
            curr = temp

        }
//        println(prev?.`val`)
//        println(prev?.next?.`val`)
//        println(prev?.next?.next?.`val`)
//        println(prev?.next?.next?.next?.`val`)

         curr = head
        var ftemp = curr
        var stemp = prev
        while(ftemp != null && stemp != null){

            ftemp = ftemp?.next
            stemp = prev?.next
//            println("----------------")
//            println(curr?.`val`)
//            println(prev?.`val`)
//            println(ftemp?.`val`)
//            println(stemp?.`val`)
//            println("----------------")
            curr?.next = prev
            prev?.next = ftemp?:prev?.next
            curr = ftemp
            prev = stemp
        }

//        println(head?.`val`)
//        println(head?.next?.`val`)
//        println(head?.next?.next?.`val`)
//        println(head?.next?.next?.next?.`val`)
//        println(head?.next?.next?.next?.next?.`val`)
//
//        println(head?.next?.next?.next?.next?.next?.`val`)


    }
}