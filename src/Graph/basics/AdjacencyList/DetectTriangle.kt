package Graph.basics.AdjacencyList

fun hasTriangle(adjacencyList: Map<Int, List<Int>>): Boolean {
    val nodes = adjacencyList.keys.toList()

    // Check all triplets (a, b, c)
    for (i in nodes.indices) {
        for (j in i + 1 until nodes.size) {
            for (k in j + 1 until nodes.size) {
                val a = nodes[i]
                val b = nodes[j]
                val c = nodes[k]

                // Check if all three edges exist
                val ab = adjacencyList[a]?.contains(b) ?: false
                val bc = adjacencyList[b]?.contains(c) ?: false
                val ca = adjacencyList[c]?.contains(a) ?: false

                if (ab && bc && ca) {
                    return true // Triangle found
                }
            }
        }
    }

    return false // No triangle
}

fun main() {
    val edges = listOf(1 to 2, 2 to 3, 3 to 1, 4 to 5)

    // Build adjacency list
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in edges) {
        adjacencyList.computeIfAbsent(u) { mutableListOf() }.add(v)
        adjacencyList.computeIfAbsent(v) { mutableListOf() }.add(u) // undirected
    }

    println("Does the graph have a triangle? ${hasTriangle(adjacencyList)}")
}
