package Tree

import java.util.*

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