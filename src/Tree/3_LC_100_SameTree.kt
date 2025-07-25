package Tree
/*
LC 100
https://leetcode.com/problems/same-tree/description/
big idea :

check val of p and q - if no return false
are p , q both null - return true

is any one null only - return false
if above three dont return then check left and right of p , q


 */
class `3_LC_100_SameTree` {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.`val` != q.`val`) return false
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

}