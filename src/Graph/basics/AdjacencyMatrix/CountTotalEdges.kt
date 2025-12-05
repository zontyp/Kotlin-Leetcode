package Graph.basics.AdjacencyMatrix

fun countEdges(matrix: Array<IntArray>): Int {
    var sum = 0

    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            sum += matrix[i][j]
        }
    }

    return sum / 2   // because undirected = double counted
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(0, 1, 1, 0, 0),
        intArrayOf(1, 0, 0, 1, 0),
        intArrayOf(1, 0, 0, 0, 1),
        intArrayOf(0, 1, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0)
    )

    val totalEdges = countEdges(matrix)
    println("Total edges = $totalEdges")
}
