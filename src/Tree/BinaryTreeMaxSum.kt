package Tree
import kotlin.math.max

fun main() {
    // Creating the tree: [10,9,20,null,null,15,7]
    val root = TreeNode(10)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    // Running the function
    val solution = BinaryTreeMaxSum()
    println("Maximum Path Sum: ${solution.maxPathSum(root)}") // Expected output: 42
}
//see maxDepth problem first
class BinaryTreeMaxSum {
    var globalMax = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)
        return globalMax
    }
    fun dfs(node:TreeNode?):Int{
        if(node == null)
            return 0
        val leftMax = max(0,dfs(node.left))
        val rightMax = max(0,dfs(node.right))
        //local max - as this current node could be the the one with max path
        val localMax = node.`val` + leftMax + rightMax
        globalMax = max(globalMax,localMax)
        //return proper value above to parent
        //if we return node.val + left + right to parent -
        // then path does not happen - path gets broken

        return node.`val`+max(leftMax,rightMax)
    }
}