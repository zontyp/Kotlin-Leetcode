package Tree

fun main() {
    var one:TreeNode? = TreeNode(1)
    var two:TreeNode? = TreeNode(2)
    var three:TreeNode? = TreeNode(3)
    var four:TreeNode? = TreeNode(4)
    var five:TreeNode? = TreeNode(5)
    one?.left = two
    one?.right = three
    two?.left = four
    two?.right = five
    one = InvertBinaryTreeRec().invertTree(one)
    println(one?.left?.`val`)
    println(one?.right?.`val`)

    println(one?.right?.left?.`val`)
    println(one?.right?.right?.`val`)
}
class InvertBinaryTreeBFS {
    fun invertTree(root: TreeNode?): TreeNode? {
        //queue of non null nodes
        val visitedNodes = ArrayDeque<TreeNode?>()
        root?.let{visitedNodes.add(it)}
        while(visitedNodes.isNotEmpty()){
            var curr = visitedNodes.removeFirst()
            curr?.left?.let{visitedNodes.add(it)}
            curr?.right?.let{visitedNodes.add(it)}

            var temp = curr?.left
            curr?.left = curr?.right
            curr?.right = temp
        }
        return root
    }
}