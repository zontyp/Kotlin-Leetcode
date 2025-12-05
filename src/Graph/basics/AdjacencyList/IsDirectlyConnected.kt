package Graph.basics.AdjacencyList

fun areDirectlyConnected(adjacencyList: Map<Int, List<Int>>, nodeA: Int, nodeB: Int): Boolean {
    // Check if nodeB is in the neighbors of nodeA
    return adjacencyList[nodeA]?.contains(nodeB) ?: false
}

fun main() {
    val edges = listOf(1 to 2, 1 to 3, 2 to 4, 3 to 5)

    // Build adjacency list
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in edges) {
        adjacencyList.computeIfAbsent(u) { mutableListOf() }.add(v)
        adjacencyList.computeIfAbsent(v) { mutableListOf() }.add(u) // undirected
    }

    val nodeA = 2
    val nodeB = 4
    val nodeC = 5
    println("Are $nodeA and $nodeB directly connected? ${areDirectlyConnected(adjacencyList, nodeA, nodeB)}")
    println("Are $nodeA and $nodeC directly connected? ${areDirectlyConnected(adjacencyList, nodeA, nodeC)}")
}
