package Graph.basics.AdjacencyList


// Remove edge (u, v) from an undirected graph adjacency list
fun removeEdge(adj: MutableMap<Int, MutableList<Int>>, u: Int, v: Int) {
    adj[u]?.remove(v)
    adj[v]?.remove(u)
}

fun main() {
    // Build adjacency list
    val adj = mutableMapOf(
        1 to mutableListOf(2, 3),
        2 to mutableListOf(1, 4),
        3 to mutableListOf(1),
        4 to mutableListOf(2)
    )

    println("Before removal:")
    println(adj)

    removeEdge(adj, 1, 3)

    println("After removal:")
    println(adj)
}
