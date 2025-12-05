package Graph.basics.AdjacencyMatrix


fun adjacencyMatrixToEdgeList(matrix: Array<IntArray>): List<Pair<Int, Int>> {
    val edges = mutableListOf<Pair<Int, Int>>()

    val n = matrix.size

    for (i in 0 until n) {
        for (j in i + 1 until n) {  // avoid double counting
            if (matrix[i][j] == 1) {
                edges.add(i to j)
            }
        }
    }

    return edges
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(0, 1, 1, 0),
        intArrayOf(1, 0, 0, 1),
        intArrayOf(1, 0, 0, 1),
        intArrayOf(0, 1, 1, 0)
    )

    val edges = adjacencyMatrixToEdgeList(matrix)

    println("Edge List:")
    for ((u, v) in edges) {
        println("$u -- $v")
    }
}
