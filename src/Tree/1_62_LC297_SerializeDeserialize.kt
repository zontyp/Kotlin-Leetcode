package Tree
import java.util.*
/*
LC 297
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
Serialization is the process of converting a data structure or
object into a sequence of bits so that it can be stored
in a file or memory buffer, or transmitted across a
network connection link to be reconstructed later in the
same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree.
There is no restriction on how your serialization/deserialization
algorithm should work. You just need to ensure that a binary
tree can be serialized to a string and this string can be deserialized
to the original tree structure.

Clarification: The input/output format is the same as how
LeetCode serializes a binary tree. You do not necessarily
need to follow this format, so please be creative and come
up with different approaches yourself.

Solution
----------------
do preorder dfs for serialize and deserialize
a) root
b) root.left
c) root.right

in deserialize - put all tokens in a linked list pull node from linked list



 */
class SerializeDeserialize {
    fun serialize(root: TreeNode?): String {
        val result = mutableListOf<String>()
        fun dfs(node:TreeNode?){
            if(node == null)
            {
                result.add("N")
                return
            }
            //preorder traversal
            result.add(node.`val`.toString())
            dfs(node.left)
            dfs(node.right)
        }
        dfs(root)
        return result.joinToString(",")
    }

    fun deserialize(data: String): TreeNode? {
        val nodeVals = LinkedList(data.split(","))
        fun dfs():TreeNode?{
            val value = nodeVals.removeFirst()
            if(value == "N") {
                return null
            }
            //preorder traversal
            val node = TreeNode(value.toInt())
            node.left = dfs()
            node.right = dfs()
            return node
        }
        return dfs()
    }
}

fun main() {
    // Creating the tree: [10,9,20,null,null,15,7]
    val root = TreeNode(10)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    // Running the function
    val solution = SerializeDeserialize()
    println("serialized result : ${solution.serialize(root)}") // Expected output: 42
}