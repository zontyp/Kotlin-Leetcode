package Tree
/*
LC 98
Validate BST

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

big idea :
If current node is left node of parent , check that
current node is less than parent

if current node is right node of parent , check that
current node is greater than parent

isValidBSTPartial gets the node as input , min , max to check for

- how to solve validate bst→for each node - check if it is between min value . max value
if node is on left of root then node value cannot be greater than max value / root value
if node is on right of root then node value cannot be less than root value
use long value as value of root node as root can be equal to the largest int value
initially set max , min as null as we do not need to compare the root value initially
also in root.left case we just need to compare the max value ,
 in root.right case we need to compare the min value
 */
fun main() {
    var one:TreeNode? = TreeNode(1)
    var two:TreeNode? = TreeNode(2)
    var three:TreeNode? = TreeNode(3)
    var four:TreeNode? = TreeNode(4)
    var five:TreeNode? = TreeNode(5)
    three?.left = two
    three?.right = four
    two?.left = one
    two?.right = five
    println(ValidateBST().isValidBST(one))
}

class ValidateBST {


fun isValidBSTPartial(root: TreeNode?, min: Int?, max: Int?): Boolean {
    if (root == null) {
        return true

    }
    if ((min != null && root.`val` <= min) || (max != null && root.`val` >= max)) {
        return false
    }
    return isValidBSTPartial(root.left, min, root.`val`) &&
            isValidBSTPartial(root.right, root.`val`, max)
}

fun isValidBST(root: TreeNode?): Boolean {
    return isValidBSTPartial(root, null, null)
}
}

