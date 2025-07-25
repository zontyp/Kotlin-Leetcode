package Backtracking

class AllSubsets {
    fun subsets(n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val leafList = mutableListOf<Int>()
        fun dfs(currentNum: Int) {
            if (currentNum > n) {
                result.add(leafList.toList()) // Add current subset
                return
            }
            // Include current number
            leafList.add(currentNum)
            dfs(currentNum + 1)
            leafList.removeLast()

            // Exclude current number
            dfs(currentNum + 1)
        }

        dfs(1)
        return result
    }



}
fun main() {
    val n = 2
    val result = AllSubsets().subsets(n)
    println("All subsets of numbers from 1 to $n:")
    result.forEach { println(it) }
}