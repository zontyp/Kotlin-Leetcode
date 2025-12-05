package Graph.basics.EdgeList

class EdgeListPrintEdges {
    fun printEdges(edges: List<Pair<Int, Int>>) {
        for ((u, v) in edges) {
            println("$u -- $v")
        }
    }
}
fun main() {
    val edges = listOf(
        0 to 1,
        0 to 2,
        1 to 3,
        3 to 4
    )

    val edgePrinter = EdgeListPrintEdges()
    edgePrinter.printEdges(edges)
}