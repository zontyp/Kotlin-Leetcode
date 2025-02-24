package Tree

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

