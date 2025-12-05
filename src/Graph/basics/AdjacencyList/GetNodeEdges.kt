package Graph.basics.AdjacencyList

fun getEdgesOfNode(adjacencyList: Map<Int, List<Int>>, node: Int): List<Pair<Int, Int>> {
    // Return a list of edges (node to neighbor)
    return adjacencyList[node]?.map { neighbor -> node to neighbor } ?: emptyList()
}

fun main() {
    val edges = listOf(1 to 2, 1 to 3, 2 to 4, 3 to 5)

    // Build adjacency list
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in edges) {
        adjacencyList.computeIfAbsent(u) { mutableListOf() }.add(v)
        adjacencyList.computeIfAbsent(v) { mutableListOf() }.add(u) // undirected
    }

    val node = 2
    val edgesOfNode = getEdgesOfNode(adjacencyList, node)
    println("Edges incident to node $node:")
    for ((u, v) in edgesOfNode) {
        println("$u -- $v")
    }
}
