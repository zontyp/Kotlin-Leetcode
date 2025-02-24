package Tree

class ConstructTreeFromTraversal {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inorderMap = inorder.withIndex().associate { it.value to it.index }
        fun buildTreeRecursive(preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
            if (preStart > preEnd || inStart > inEnd) return null
            val rootValue = preorder[preStart]
            val root = TreeNode(rootValue)
            val rootIndex = inorderMap[rootValue]!!
            val leftSize = rootIndex - inStart
            root.left = buildTreeRecursive(preStart + 1, preStart + leftSize, inStart, rootIndex - 1)
            root.right = buildTreeRecursive(preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd)
            return root
        }
        return buildTreeRecursive(0, preorder.size - 1, 0, inorder.size - 1)


    }
}