package DP
/*
Question:
You are given an m x n integer array grid.
There is a robot initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid.
A path that the robot takes cannot include any square that is an obstacle.

Explaination:
same as LC 62 unique path.
while initializing we need to make cell 0 if that cell is obstacle.
for row initialization cell will have the value of its right cell or 0 if that input cell is obstacle
for column initialization , dp cell will have value of bottom cell or 0 if that input cell is obstacle

dp cell will have value 0 if that input cell is obstacle
 */
fun main() {
    val input = arrayOf(
        intArrayOf(0,0,0),
        intArrayOf(0,1,0),
        intArrayOf(0,0,0)
    )
    uniquePathsWithObstacles(input).let{ println(it) }
}
fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
        return 0
    val dp = Array(m){IntArray(n)}
    dp[m-1][n-1] = 1
    //initialize last row
    for(i in n-2 downTo 0){
        dp[m-1][i] = if(obstacleGrid[m-1][i] == 1) 0 else dp[m-1][i+1]
    }
    //initialize last column
    for(j in m-2 downTo 0){
        dp[j][n-1] = if(obstacleGrid[j][n-1] == 1) 0 else dp[j+1][n-1]
    }
    for(i in m-2 downTo 0){
        for(j in n-2 downTo 0){
            //right + down
            if(obstacleGrid[i][j] == 1)
                dp[i][j] = 0
            else
            dp[i][j] = dp[i][j+1] + dp [i+1][j]
        }
    }
    return dp[0][0]

}