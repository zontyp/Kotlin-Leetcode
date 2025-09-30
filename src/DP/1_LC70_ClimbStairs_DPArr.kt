package DP

class ClimbStairsDPArr {
    fun climbStairs(n: Int): Int {
        // Base cases
        if (n <= 2) return n

        // dp[i] will store the number of ways to reach step i
        val dp = IntArray(n + 1)
        dp[0] = 1  // 1 way to stay at step 0 (do nothing)
        dp[1] = 1  // 1 way to reach step 1

        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}

fun main() {
    val solution = ClimbStairsDPArr()
    val n = 5
    println("Number of ways to climb $n steps: ${solution.climbStairs(n)}")
}
