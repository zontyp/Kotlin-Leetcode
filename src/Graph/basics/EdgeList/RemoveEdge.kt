package Graph.basics.EdgeList


// Remove an edge from edge list (undirected)
fun removeEdge(edges: MutableList<Pair<Int, Int>>, u: Int, v: Int) {
    edges.removeIf { (a, b) ->
        (a == u && b == v) || (a == v && b == u)
    }
}

fun main() {
    val edges = mutableListOf(
        1 to 2,
        2 to 3,
        3 to 4,
        1 to 3
    )

    println("Before removal: $edges")

    removeEdge(edges, 1, 3)

    println("After removal:  $edges")
}
