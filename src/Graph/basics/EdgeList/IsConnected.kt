package Graph.basics.EdgeList

fun isConnected(edges: List<Pair<Int, Int>>, a: Int, b: Int): Boolean {
    for ((u, v) in edges) {
        if ((u == a && v == b) || (u == b && v == a)) {
            return true
        }
    }
    return false
}

fun main() {
    val edges = listOf(
        1 to 2,
        2 to 3,
        4 to 5,
        6 to 7
    )

    println("Is 1 connected to 2? => " + isConnected(edges, 1, 2))
    println("Is 2 connected to 4? => " + isConnected(edges, 2, 4))
    println("Is 4 connected to 5? => " + isConnected(edges, 4, 5))
    println("Is 3 connected to 2? => " + isConnected(edges, 3, 2))
}
