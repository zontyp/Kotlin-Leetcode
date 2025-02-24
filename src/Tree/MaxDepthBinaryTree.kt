package Tree

class MaxDepthBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        var left = 0
        var right = 0
        if(root == null){
            return 0
        }
        left = maxDepth(root?.left)
        right = maxDepth(root?.right)
        return 1+ Math.max(left,right)
    }
}