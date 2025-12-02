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
    BFSLevelOrder().levelOrder(one).let{ println(it) }
}
class BFSLevelOrder {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val visitedNodes = ArrayDeque<TreeNode>()
        root?.let{visitedNodes.add(it)}
        while(visitedNodes.isNotEmpty()){
            val currLevelNodeList = mutableListOf<TreeNode>()
            val currLevelIntList = mutableListOf<Int>()
            for(curr in visitedNodes) { 
                currLevelNodeList.add(curr)
                currLevelIntList.add(curr.`val`)
            }
            visitedNodes.clear()
            result.add(currLevelIntList)
            currLevelNodeList.forEach {
                it.left?.let{visitedNodes.add(it)}
                it.right?.let{visitedNodes.add(it)}

            }


        }
        return result.toList()
        }
    }
