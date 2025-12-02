package Tree
import kotlin.math.max
/*
Lc124
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
A path in a binary tree is a sequence of nodes where each pair
of adjacent nodes in the sequence has an edge connecting them.
A node can only appear in the sequence at most once.
 Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

Big Idea :
------------------------------------------------------

find max path sum at each node
return max of max path sums of each node

localmax = node.val + leftmax + rightmax

leftmax = max(0,dfs(node.left))

dfs needs to return node.val + max(leftmax,rightmax) => either
left or right branch to parent to maintain path structure
 */
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
        //if leftMax or rightMax < 0 then ignore them
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