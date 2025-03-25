package DP
class Uniquepaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m+1){IntArray(n+1)}
        for (i in 0 until m) dp[i][n-1] = 1  // Last column
        for (j in 0 until n) dp[m-1][j] = 1  // Last row
        for( i in m-2 downTo 0) {
            for (j in n - 2 downTo 0) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
            }
        }
        return dp[0][0]
    }
}