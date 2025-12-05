package Graph.basics.AdjacencyList

fun countTotalEdges(adjacencyList: Map<Int, List<Int>>): Int {
    // Sum the sizes of all neighbor lists and divide by 2
    return adjacencyList.values.sumOf { it.size } / 2
}

fun main() {
    val edges = listOf(1 to 2, 1 to 3, 2 to 4, 3 to 5)

    // Build adjacency list
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in edges) {
        adjacencyList.computeIfAbsent(u) { mutableListOf() }.add(v)
        adjacencyList.computeIfAbsent(v) { mutableListOf() }.add(u) // undirected
    }

    val totalEdges = countTotalEdges(adjacencyList)
    println("Total number of edges: $totalEdges")
}
