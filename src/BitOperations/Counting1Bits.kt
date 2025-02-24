package BitOperations

fun main() {
    val n = 5
    val result = Counting1Bits().countBits(n)
    for (i in result) {
        println(i)
    }
}
class Counting1Bits {
    fun countBits(n: Int): IntArray {
        val ans = IntArray(n + 1)
        for (i in 1..n) {
            ans[i] = ans[i shr 1] + (i % 2)

        }
        return ans
    }
}