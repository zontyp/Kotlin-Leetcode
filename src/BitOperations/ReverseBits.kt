package BitOperations
/*
LC 190
https://leetcode.com/problems/reverse-bits/description/
idea:
suppose we have 10010
we need to make it 01001

so big idea is take the rightmost bit , add it to result and shift result to left after adding the bit to result
total 31 bits need to be shifted by 1 to reverse the bits
val rightmost = n.and(1)

r.or(rightmost)
r.shl(1)
suppose we have 0001
rightmost = 1
r = 0001
r.shl(1)
0010
if we do this 2 more times
we get 1000

we need to shift 31 times
 */

fun main() {
    ReverseBits().reverseBits(5).let { println(it.toUInt()) }
}
class ReverseBits {
    fun reverseBits(n: Int): Int {
        var result = 0
        var n = n  // Mutable copy of n to modify it in the loop

        for (i in 0 until 32) {
            val rightMost = n.and(1)  // Extract the rightmost bit
            // first time - dont shift anything  - we need to shift 31 times total
            result = result.shl(1)    // Shift the result left by 1 to make space for the next bit

            result = result.or(rightMost)  // Add the rightmost bit to the result
            n = n.shr(1)  // Shift `n` right by 1 to process the next bit
        }

        return result
    }


}