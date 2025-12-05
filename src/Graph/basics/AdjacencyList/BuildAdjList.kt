package Graph.basics.AdjacencyList

fun buildAdjacencyList(edges: List<Pair<Int, Int>>): Map<Int, List<Int>> {
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in edges) {
        adjacencyList.computeIfAbsent(u) { mutableListOf() }.add(v)
        adjacencyList.computeIfAbsent(v) { mutableListOf() }.add(u) // for undirected graph
    }

    return adjacencyList
}

fun main() {
    val edges = listOf(1 to 2, 1 to 3, 2 to 4)
    val adjacencyList = buildAdjacencyList(edges)

    println("Adjacency List:")
    for ((node, neighbors) in adjacencyList) {
        println("$node -> $neighbors")
    }
}
