package DP

class LongestCommonSubsequence {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val dp = Array(m+1){IntArray(n+1)}
        for(i in m-1 downTo 0){
            for(j in n-1 downTo 0){
                dp[i][j] = if(text1[i] == text2[j]){
                    1 + dp[i+1][j+1]
                }
                else{
                    maxOf(dp[i+1][j],dp[i][j+1])
                }
            }
        }
        return dp[0][0]
    }


}
fun main() {
    val lcsSolver = LongestCommonSubsequence()

    val text1 = "abcde"
    val text2 = "ace"

    val result = lcsSolver.longestCommonSubsequence(text1, text2)

    println("Longest Common Subsequence length: $result") // Expected output: 3
}