package Graph.basics.EdgeList

fun addEdge(edgeList: MutableList<Pair<Int, Int>>, u: Int, v: Int) {
    edgeList.add(Pair(u, v))
    edgeList.add(Pair(v, u))   // if you want undirected
}

fun main() {
    val edges = mutableListOf<Pair<Int, Int>>()

    addEdge(edges, 0, 1)
    addEdge(edges, 1, 2)
    addEdge(edges, 2, 3)

    println(edges)
}
