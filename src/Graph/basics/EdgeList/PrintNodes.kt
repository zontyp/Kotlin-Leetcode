package Graph.basics.EdgeList
class EdgeListNodes {

    fun getNodes(edges: List<Pair<Int, Int>>): Set<Int> {
        val nodes = mutableSetOf<Int>()
        for ((u, v) in edges) {
            nodes.add(u)
            nodes.add(v)
        }
        return nodes
    }
}

fun main() {
    val edges = listOf(
        0 to 1,
        2 to 3,
        3 to 4,
        4 to 1,
        5 to 2
    )

    val helper = EdgeListNodes()
    val nodes = helper.getNodes(edges)

    println("All unique nodes:")
    println(nodes)
}
