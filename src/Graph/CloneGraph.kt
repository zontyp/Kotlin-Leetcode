package Graph

 class Node(var `val`: Int) {
     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 }

class CloneGraph {
    fun cloneGraph(node: Node?): Node? {
        if(node == null)
            return null
        val visited = mutableMapOf<Node,Node>()
        return cloneGraphDFS(node,visited)

    }
    //this function will always return cloned node
    fun cloneGraphDFS(node:Node?,visited:MutableMap<Node,Node>):Node?{
        if(node == null)
            return null
        if(node in visited){
            return visited[node]!!
        }
        val newNode = Node(node.`val`)
        visited.put(node,newNode)
        for(neighbour in node.neighbors){
            newNode.neighbors.add(cloneGraphDFS(neighbour,visited))
        }
        return newNode
    }
}