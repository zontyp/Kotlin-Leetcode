package Tree
/*
LC 105
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
Given two integer arrays preorder and inorder where preorder
is the preorder traversal of a binary tree and inorder
is the inorder traversal of the same tree, construct and return the binary tree.

first element of preorder is the root
left of that element in inorder is the left subtree
right of that element in inorder is the right subtree

keep repeating above ideas and build the tree
ultimately - one root is there , one left is there , one right is there

when one element is also not remaining to make tree
we reach base case and return null

we recursively call buildsubtree with start index and end index of the tree

when one element is there its valid call , after that nothing is there
to build tree
start index > end index
so we return null

base case is bit similar to binary search
 */

class Solution {
    private var preIndex = 0
    private lateinit var inorderIndexMap: Map<Int, Int>

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

        inorderIndexMap = inorder.withIndex().associate { (i, v) -> v to i }
        return buildSubtree(preorder, 0, inorder.size - 1)
    }

    private fun buildSubtree(preorder: IntArray, inStart: Int, inEnd: Int): TreeNode? {
        if (inStart > inEnd) return null // ✅ Base case

        val rootVal = preorder[preIndex++]
        val root = TreeNode(rootVal)
        val inIndex = inorderIndexMap[rootVal]!!

        root.left = buildSubtree(preorder, inStart, inIndex - 1)
        root.right = buildSubtree(preorder, inIndex + 1, inEnd)

        return root
    }
}

// Helper to print preorder traversal of tree
fun preorderTraversal(node: TreeNode?): List<Int> {
    if (node == null) return emptyList()
    return listOf(node.`val`) + preorderTraversal(node.left) + preorderTraversal(node.right)
}

// ✅ Main function to test the solution
fun main() {
    val preorder = intArrayOf(1, 2, 4, 5, 3, 6)
    val inorder = intArrayOf(4, 2, 5, 1, 3, 6)

    val solution = Solution()
    val root = solution.buildTree(preorder, inorder)

    println("Preorder of constructed tree: ${preorderTraversal(root)}")
}
