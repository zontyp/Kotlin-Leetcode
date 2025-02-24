package Tree

fun main() {
    var three:TreeNode? = TreeNode(3)
    var one:TreeNode? = TreeNode(1)
    var four:TreeNode? = TreeNode(4)
    var two:TreeNode? = TreeNode(2)
    three?.left = one
    three?.right = four
    one?.right = two

    BSTKSmall().kthSmallest(three,4).let{ println(it) }
}
class BSTKSmall {

    var kCopy = 0
    var result = -1
    fun kthSmallest(root: TreeNode?, k: Int):Int{
        kthSmallestDFS(root,k)
        return result
    }
    fun kthSmallestDFS(root: TreeNode?, k: Int) {
        if(root == null)
            return
        kthSmallest(root?.left,k)
        kCopy++
        if(kCopy == k)
            result = root.`val`
        kthSmallest(root?.right,k)

    }
}