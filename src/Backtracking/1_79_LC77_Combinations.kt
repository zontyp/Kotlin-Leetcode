
/*
https://leetcode.com/problems/combinations/description/
Given two integers n and k, return all possible combinations of k
numbers chosen from the range [1, n].

You may return the answer in any order.

 */
/* similar to subsequences
take , not take current element
 */
fun combine(n: Int, k: Int): List<List<Int>> {
    val leafList = mutableListOf<Int>() // Stores current combination
    val result = mutableListOf<List<Int>>() // Stores all valid combinations

    fun dfs(currentNum: Int, k: Int) {
        // Base case: If we have selected k numbers, add the combination to result
        if (k == 0) {
            println(leafList)
            result.add(leafList.toList()) // Store a copy of leafList
            return
        }

        // If currentNum exceeds n, stop recursion
        if (currentNum > n) return

        // Include currentNum in combination
        leafList.add(currentNum)
        dfs(currentNum + 1, k - 1) // Move to the next number with one less slot to fill
        leafList.removeLast() // Backtrack to explore other possibilities

        // Exclude currentNum from combination and move to the next number
        dfs(currentNum + 1, k)
    }

    dfs(1, k) // Start DFS from 1
    return result
}

fun main() {
    val n = 2  // Range from 1 to n
    val k = 2  // Select k elements
    val result = combine(n, k)
    println("Combinations of $k numbers from 1 to $n:")
    result.forEach { println(it) }
}

