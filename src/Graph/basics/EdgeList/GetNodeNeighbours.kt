package Graph.basics.EdgeList

fun getNeighbors(edges: List<Pair<Int, Int>>, node: Int): List<Int> {
    val list = mutableListOf<Int>()
    for ((u, v) in edges) {
        if (u == node) list.add(v)
        if (v == node) list.add(u)
    }
    return list
}

fun main() {

    val edges = listOf(
        0 to 1,
        0 to 2,
        1 to 3,
        2 to 3,
        3 to 4
    )

    val node = 3
    val neighbors = getNeighbors(edges, node)

    println("Neighbors of node $node:")
    for (n in neighbors) {
        println(n)
    }
}
