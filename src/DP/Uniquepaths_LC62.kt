package DP
/*
There is a robot on an m x n grid.
The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
robot can only move down or right at any point in time.
find number of unique paths
Explaination:
 look at the destination.
 look at cell above destination - for this cell 'a' answer is 1
 look at cell to left of destination - for this cell 'b' answer is 1
 now look at cell diagonally to left of destination , for this cell answer is 'a' + 'b'
 for any cell , answer is addition of cell below it and cell to the right of it .
 */
fun main() {
    uniquePaths(2,2).let { println(it) }
}
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m){IntArray(n)}
        for (i in 0 until m) dp[i][n-1] = 1  // Last column
        for (j in 0 until n) dp[m-1][j] = 1  // Last row
        for( i in m-2 downTo 0) {
            for (j in n - 2 downTo 0) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
            }
        }
        return dp[0][0]
    }
