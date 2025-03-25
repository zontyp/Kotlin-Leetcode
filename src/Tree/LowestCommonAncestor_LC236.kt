package Tree

fun main() {
    var three:TreeNode? = TreeNode(3)
    var one:TreeNode? = TreeNode(1)
    var four:TreeNode? = TreeNode(4)
    var two:TreeNode? = TreeNode(2)
    three?.left = one
    three?.right = four
    one?.right = two

    LowestCommonAncestor().lowestCommonAncestor(three,one,two).let{ println(it?.`val`) }
}
class LowestCommonAncestor {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var node = root
        while(node!=null){
            node = when {
                p!!.`val` < node.`val` && q!!.`val` < node.`val` -> node.left
                p.`val` > node.`val` && q!!.`val` > node.`val` -> node.right
                else -> return node
            }
        }
        return null
    }

    }