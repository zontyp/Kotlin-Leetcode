package Graph.basics.AdjacencyList

// Add edge to adjacency list (undirected graph)
fun addEdge(adj: MutableList<MutableList<Int>>, u: Int, v: Int) {
    adj[u].add(v)
    adj[v].add(u)   // undirected
}

fun main() {
    val n = 5
    val adj = MutableList(n) { mutableListOf<Int>() }

    addEdge(adj, 0, 1)
    addEdge(adj, 1, 2)
    addEdge(adj, 2, 3)
    addEdge(adj, 3, 4)

    println(adj)
}
