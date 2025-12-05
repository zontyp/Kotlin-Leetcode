package Graph.basics.EdgeList

fun hasTriangle(edges: List<Pair<Int, Int>>): Boolean {
    // Step 1: Build edgeSet and nodes in a single loop
    val edgeSet = mutableSetOf<Pair<Int, Int>>()
    val nodes = mutableSetOf<Int>()

    for ((u, v) in edges) {
        edgeSet.add(u to v)
        edgeSet.add(v to u)  // Add reverse for undirected graph

        nodes.add(u)
        nodes.add(v)
    }

    val nodeList = nodes.toList()
    val n = nodeList.size

    // Step 2: Check all triplets (a, b, c)
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                val a = nodeList[i]
                val b = nodeList[j]
                val c = nodeList[k]

                // Check all three edges exist
                if (edgeSet.contains(a to b) &&
                    edgeSet.contains(b to c) &&
                    edgeSet.contains(c to a)) {
                    return true // Triangle found
                }
            }
        }
    }

    return false // No triangle
}

fun main() {
    // Example edge list
    val edges = listOf(
        1 to 2,
        2 to 3,
        3 to 1,   // This forms a triangle
        4 to 5
    )

    val result = hasTriangle(edges)
    if (result) {
        println("The graph contains at least one triangle.")
    } else {
        println("The graph does not contain any triangle.")
    }
}

