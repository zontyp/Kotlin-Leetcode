package BitOperations
/*
LC 191
https://leetcode.com/problems/number-of-1-bits/description/
idea:
when we do
n & n - 1
we reset the rightmost 1
all 0's to the right of the rightmost 1 stay as 0

so keep doing n & n - 1 to reset all 1's from right to left
keep doing n & n - 1 until n becomes 0
and count how many times we did this
 */
fun main() {
      println(Number1Bits().hammingWeight(2))
}
class Number1Bits {
    fun hammingWeight(n: Int): Int {
        var input = n
        var count = 0
        while(input!=0){
            input = input.and(input-1)
            count++
        }
        return count
    }
}