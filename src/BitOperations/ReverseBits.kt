package BitOperations

fun main() {
    ReverseBits().reverseBits(5).let { println(it.toUInt()) }
}
class ReverseBits {
    fun reverseBits(n: Int): Int {
        var result = 0
        var n = n  // Mutable copy of n to modify it in the loop

        for (i in 0 until 32) {
            val rightMost = n.and(1)  // Extract the rightmost bit
            result = result.shl(1)    // Shift the result left by 1 to make space for the next bit
            result = result.or(rightMost)  // Add the rightmost bit to the result
            n = n.shr(1)  // Shift `n` right by 1 to process the next bit
        }

        return result
    }


}