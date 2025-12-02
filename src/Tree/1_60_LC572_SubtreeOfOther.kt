package Tree
/*
https://leetcode.com/problems/subtree-of-another-tree/

Given the roots of two binary trees root and subRoot,
return true if there is a subtree of root with the same
 structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists
 of a node in tree and all of this node's descendants.
  The tree tree could also be considered as a subtree of itself.

*/

fun main() {
    var one:TreeNode? = TreeNode(3)
    var two:TreeNode? = TreeNode(4)
    var three:TreeNode? = TreeNode(5)
    var four:TreeNode? = TreeNode(1)
    var five:TreeNode? = TreeNode(2)
    one?.left = two
    one?.right = three
    two?.left = four
    two?.right = five

    var six:TreeNode? = TreeNode(4)
    var seven:TreeNode? = TreeNode(1)
    var eight:TreeNode? = TreeNode(2)
    six?.left = seven
    six?.right = eight

    println(SubtreeOfOther().isSubtree(one,six))
}
class SubtreeOfOther {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if(p == null && q == null) return true
        if(p == null || q == null) return false
        if(p.`val` != q.`val`) return false
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right)
    }
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(root == null) return false
        if(isSameTree(root,subRoot)) return true
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot)
    }
}