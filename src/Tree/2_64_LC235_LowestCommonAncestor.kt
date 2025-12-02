package Tree
/*
LC 235
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q
as the lowest node in T that has both p and q as descendants
 (where we allow a node to be a descendant of itself).”

 Bog idea :

 for current node ,
 if both p,q are on left of current node
 then lca is also on left of current node

 if both p, q are on right of current node
 then lca is on right of current node

 if p and q are on either side of current node
 then current node is LCA

 if p is ancestor of q
 then also - both p and q are not on either left or right of current node p.
 same for if q is ancestor of p


 */
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