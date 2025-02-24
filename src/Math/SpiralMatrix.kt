package Math

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    SpiralMatrix().spiralOrder(matrix).forEach {
        println(it)
    }
}
class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var current = 0 to 0
        val result = mutableListOf<Int>()
        //right , down , left , up
        val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        var currentDirection = 0
        val totalElements = matrix.size * matrix[0].size
        val visited = hashSetOf<Pair<Int, Int>>()
        visited.add(current)
        result.add(matrix[current.first][current.second])
        while (totalElements > result.size) {
            val next =
                current.first + directions[currentDirection].first to current.second + directions[currentDirection].second
            if (next.first < 0 || next.first >= matrix.size ||
                next.second < 0 || next.second >= matrix[0].size ||
                visited.contains(next)
            ) {
                currentDirection = (currentDirection + 1) % 4
            } else {
                current = next
                visited.add(current)
                result.add(matrix[current.first][current.second])
            }
        }
        return result
    }
}