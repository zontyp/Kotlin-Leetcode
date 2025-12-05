package Graph.basics.AdjacencyMatrix


// Add edge to adjacency matrix (undirected graph)
fun addEdge(matrix: Array<IntArray>, u: Int, v: Int) {
    matrix[u][v] = 1
    matrix[v][u] = 1
}

fun main() {
    val n = 5
    val matrix = Array(n) { IntArray(n) { 0 } }

    addEdge(matrix, 0, 1)
    addEdge(matrix, 1, 2)
    addEdge(matrix, 3, 4)

    // print matrix
    for (row in matrix) {
        println(row.joinToString(" "))
    }
}
