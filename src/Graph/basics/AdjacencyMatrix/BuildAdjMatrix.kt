package Graph.basics.AdjacencyMatrix

fun buildAdjacencyMatrix(edges: List<Pair<Int, Int>>): Array<IntArray> {
    // Step 1: Collect all unique nodes
    val nodes = edges
        .flatMap { listOf(it.first, it.second) }
        .distinct()
        .sorted()

    val indexMap = nodes.withIndex().associate { it.value to it.index }
    val n = nodes.size

    // Step 2: Create NxN matrix initialized with 0
    val matrix = Array(n) { IntArray(n) }

    // Step 3: Fill matrix for each edge (undirected)
    for ((u, v) in edges) {
        val i = indexMap[u]!!
        val j = indexMap[v]!!
        matrix[i][j] = 1
        matrix[j][i] = 1 // undirected graph
    }

    return matrix
}

fun main() {
    val edges = listOf(
        1 to 2,
        1 to 3,
        2 to 4,
        3 to 5
    )

    val matrix = buildAdjacencyMatrix(edges)

    println("Adjacency Matrix:")
    for (row in matrix) {
        println(row.joinToString(" "))
    }
}
