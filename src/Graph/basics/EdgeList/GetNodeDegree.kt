package Graph.basics.EdgeList

class GetNodeDegree {

    fun getDegrees(edges: List<Pair<Int, Int>>): Map<Int, Int> {
        val degree = mutableMapOf<Int, Int>()

        for ((u, v) in edges) {
            degree[u] = (degree[u] ?: 0) + 1
            degree[v] = (degree[v] ?: 0) + 1
        }
        // Find node with maximum degree
//        return degreeMap.maxByOrNull { it.value }?.toPair()
        return degree
    }
}

fun main() {
    val edges = listOf(
        0 to 1,
        0 to 2,
        1 to 2,
        2 to 3,
        3 to 4
    )
    val degrees = GetNodeDegree().getDegrees(edges)

    println("Node Degrees:")
    for ((node, degree) in degrees) {
        println("Node $node → Degree $degree")
    }
}
