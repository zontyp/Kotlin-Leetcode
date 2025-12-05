package Graph.basics.AdjacencyMatrix

fun adjacencyMatrixToList(matrix: Array<IntArray>): MutableMap<Int, MutableList<Int>> {
    val n = matrix.size
    val adj = mutableMapOf<Int, MutableList<Int>>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (matrix[i][j] == 1) {
                adj.computeIfAbsent(i) { mutableListOf() }.add(j)
            }
        }
    }

    return adj
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(0, 1, 0, 1), // 0 -> 1,3
        intArrayOf(1, 0, 1, 0), // 1 -> 0,2
        intArrayOf(0, 1, 0, 0), // 2 -> 1
        intArrayOf(1, 0, 0, 0)  // 3 -> 0
    )

    val adjList = adjacencyMatrixToList(matrix)

    println("Adjacency List:")
    for ((node, edges) in adjList) {
        println("$node -> $edges")
    }
}
