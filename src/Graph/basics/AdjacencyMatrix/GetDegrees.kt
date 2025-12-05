package Graph.basics.AdjacencyMatrix


fun getDegrees(matrix: Array<IntArray>): List<Int> {
    val degrees = mutableListOf<Int>()

    for (i in matrix.indices) {
        var count = 0
        for (j in matrix[i].indices) {
            count += matrix[i][j]
        }
        degrees.add(count)
    }

    return degrees
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(0, 1, 1, 0, 0), // node 0
        intArrayOf(1, 0, 0, 1, 0), // node 1
        intArrayOf(1, 0, 0, 0, 1), // node 2
        intArrayOf(0, 1, 0, 0, 0), // node 3
        intArrayOf(0, 0, 1, 0, 0)  // node 4
    )

    val degrees = getDegrees(matrix)

    println("Degrees of each node:")
    degrees.forEachIndexed { index, deg ->
        println("Node $index => degree = $deg")
    }
}
