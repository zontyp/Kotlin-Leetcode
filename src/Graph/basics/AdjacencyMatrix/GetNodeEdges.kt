package Graph.basics.AdjacencyMatrix

fun getNodeEdges(matrix: Array<IntArray>, node: Int): List<Int> {
    val neighbors = mutableListOf<Int>()

    for (j in matrix[node].indices) {
        if (matrix[node][j] == 1) {
            neighbors.add(j)
        }
    }

    return neighbors
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(0, 1, 1, 0, 0), // node 0
        intArrayOf(1, 0, 0, 1, 0), // node 1
        intArrayOf(1, 0, 0, 0, 1), // node 2
        intArrayOf(0, 1, 0, 0, 0), // node 3
        intArrayOf(0, 0, 1, 0, 0)  // node 4
    )

    val node = 2
    val neighbors = getNodeEdges(matrix, node)

    println("Neighbors of node $node: $neighbors")
}
