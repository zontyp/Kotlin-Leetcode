package Graph.basics.AdjacencyList

fun computeNodeDegrees(adjacencyList: Map<Int, List<Int>>): Map<Int, Int> {
    val degrees = mutableMapOf<Int, Int>()
    for ((node, neighbors) in adjacencyList) {
        degrees[node] = neighbors.size
    }
    return degrees
}

fun main() {
    // Example edges
    val edges = listOf(1 to 2, 1 to 3, 2 to 4)
    // Build adjacency list
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in edges) {
        adjacencyList.computeIfAbsent(u) { mutableListOf() }.add(v)
        adjacencyList.computeIfAbsent(v) { mutableListOf() }.add(u) // undirected
    }
    // Compute degrees
    val degrees = computeNodeDegrees(adjacencyList)

    // Print degrees
    println("Node Degrees:")
    for ((node, degree) in degrees) {
        println("Node $node -> Degree $degree")
    }
}
