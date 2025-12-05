package DP
/*
LC 91
https://leetcode.com/problems/decode-ways/description/
You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'
"2" -> 'B'
...
"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").
For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.
The test cases are generated so that the answer fits in a 32-bit integer.

--- big idea ---
at a character - you can do two things :
a) take that character
b) take that character and the previous character

if you do a) then dp[i] += dp[i-1]
if you do b) then dp[i]+= dp[i-2]

"226"
dp0 = 1
dp1 = 1

dp2 :
2_2_6
1st char 2 is valid
dp2 += dp1

also _22_6
22 is valid
so dp2+= dp0

sp dp2 = 2
-------------------
dp3:
we can select 6 or 26
both ara valid
if we select 6
dp3 += dp2
if we select 26
dp3 += dp1

sp dp3 = 2 + 1 = 3
 */
fun main() {
    println(DecodeWays().numDecodings("226"))
}
class DecodeWays {
    fun numDecodings(s: String): Int {
        if(s.isEmpty() || s[0] == '0') return 0
        //dp[1] gives number of ways for decoding first character of input string
        //dp[2] gives number of ways for decoding first two characters of input string
        val dp = IntArray(s.length + 1) // 0 value array
        dp[0] = 1
        dp[1] = 1
        for(i in 2..s.length){
            val oneDigit = s.substring(i-1,i).toInt() //s[i-1]
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