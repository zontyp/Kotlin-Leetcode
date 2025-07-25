package Tree
/*
lc104
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along
the longest path from the root node down to the farthest leaf node.
BASE CASE :
when root is null - max depth is 0

big idea :
max depth is either in left or in right
if left is deeper - max depth is in left
if right is deeper - max depth is in right
can we find max depth of root without any children -
yes its 0
so base case is if root == null ,return 0

can we find max depth with one level of children
yes by recursion
pass root.left , root.right to function so that we arrive at base case
and return 1 while backtracking so that
every time we call maxdepth function , 1 is added

we can do with bfs as well

time complexity is o(log n) for balanced tree
o(n) for unbalanced tree
 */
class `2_LC104_MaxDepthBinaryTree` {
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