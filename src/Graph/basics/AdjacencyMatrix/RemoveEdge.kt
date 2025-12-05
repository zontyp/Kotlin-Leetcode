package Graph.basics.AdjacencyMatrix

// Remove edge (u, v) from adjacency matrix for an undirected graph
fun removeEdge(matrix: Array<IntArray>, u: Int, v: Int) {
    matrix[u][v] = 0
    matrix[v][u] = 0
}

fun main() {
    val n = 5
    val matrix = Array(n) { IntArray(n) { 0 } }

    // Add some edges
    matrix[0][1] = 1
    matrix[1][0] = 1

    matrix[1][2] = 1
    matrix[2][1] = 1

    matrix[3][4] = 1
    matrix[4][3] = 1

    println("Before removal:")
    for (row in matrix) println(row.joinToString(" "))

    removeEdge(matrix, 1, 2)

    println("\nAfter removal:")
    for (row in matrix) println(row.joinToString(" "))
}
