package DP

class MinCostStairs {

    // 🪜 Function to calculate minimum cost to reach the top of stairs
    fun minCostClimbingStairs(cost: IntArray): Int {

        val n = cost.size
        val dp = IntArray(n + 1) // 💾 dp[i] = minimum cost to reach step i

        dp[0] = 0 // 🟦 Starting at step 0 costs nothing
        dp[1] = 0 // 🟦 Starting at step 1 also costs nothing

        // 📈 Build the DP array bottom-up
        for (i in 2..n) {

            // Option 1: Jump from previous step (i−1)
            val fromPrev = cost[i - 1] + dp[i - 1]

            // Option 2: Jump from step before that (i−2)
            val fromPrevPrev = cost[i - 2] + dp[i - 2]

            // ✔ Choose the minimum of the two options
            dp[i] = minOf(fromPrev, fromPrevPrev)
        }

        return dp[n] // 🎯 dp[n] = min cost to reach beyond last step
    }
}

// ▶️ Main function to test
fun main() {

    val cost = intArrayOf(10, 15, 20) // 🎒 Input cost array

    // 🚀 Calling the function
    val result = MinCostStairs().minCostClimbingStairs(cost)

    println("Minimum cost to reach the top: $result 💡")
}
