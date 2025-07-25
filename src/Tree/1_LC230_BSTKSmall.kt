package Tree
/*
LC230
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
Given the root of a binary search tree, and an integer k,
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Big idea :
Inorder traversal gives us the k smallest element

we do not want complete inorder traversal to continue
so we use if(count >=k) check at beginning of dfs
so dfs is not execures after count exceeds k
 */
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

    private var count = 0
    private var result = -1
    fun kthSmallest(root: TreeNode?, k: Int):Int{
        inorder(root, k)
        return result
    }
    private fun inorder(node: TreeNode?, k: Int) {
        if (node == null || count >= k) return

        inorder(node.left, k)

        count++
        if (count == k) {
            result = node.`val`
            return
        }

        inorder(node.right, k)
    }
}