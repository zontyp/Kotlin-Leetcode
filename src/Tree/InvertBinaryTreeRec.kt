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
  class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
  }

class InvertBinaryTreeRec {
    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null){
            return null
        }
        val node = TreeNode(root.`val`)
        node.right = invertTree(root.left)
        node.left = invertTree(root.right)
        return node
    }
}