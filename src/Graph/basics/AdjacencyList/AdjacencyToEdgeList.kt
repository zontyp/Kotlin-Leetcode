package Graph.basics.AdjacencyList

fun adjacencyToEdgeList(adj: Map<Int, List<Int>>): List<Pair<Int, Int>> {
    val edges = mutableListOf<Pair<Int, Int>>()
    val seen = mutableSetOf<Pair<Int, Int>>()   // To avoid duplicates

    for ((u, neighbors) in adj) {
        for (v in neighbors) {
            // Always store (small, big) so duplicates are avoided
            val edge = if (u < v) u to v else v to u

            if (edge !in seen) {
                seen.add(edge)
                edges.add(edge)
            }
        }
    }

    return edges
}

fun main() {
    // Example adjacency list
    val adj = mapOf(
        1 to listOf(2, 3),
        2 to listOf(1, 4),
        3 to listOf(1, 5),
        4 to listOf(2),
        5 to listOf(3)
    )

    val edges = adjacencyToEdgeList(adj)
    println("Edge List:")
    for ((u, v) in edges) {
        println("$u -- $v")
    }
}
