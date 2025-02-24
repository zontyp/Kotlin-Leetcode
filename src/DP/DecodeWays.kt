package DP

fun main() {
    println(DecodeWays().numDecodings("226"))
}
class DecodeWays {
    fun numDecodings(s: String): Int {
        if(s.isEmpty() || s[0] == '0') return 0
        //dp[1] gives number of ways for decoding first character of input string
        //dp[2] gives number of ways for decoding first two characters of input string
        val dp = IntArray(s.length + 1)
        dp[0] = 1
        dp[1] = 1
        for(i in 2..s.length){
            val oneDigit = s.substring(i-1,i).toInt()
            val twoDigit = s.substring(i-2,i).toInt()
            if(oneDigit in 1..9){
                dp[i] += dp[i-1]
            }
            if(twoDigit in 10..26){
                dp[i] += dp[i-2]
            }
        }
        return dp[s.length]
    }
}