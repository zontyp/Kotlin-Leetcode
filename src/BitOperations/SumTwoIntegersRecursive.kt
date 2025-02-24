package BitOperations

fun main() {
    SumTwoIntegers().getSum(3, 2).let { println(it) }
}
class SumTwoIntegers {
    fun getSum(a: Int, b: Int): Int {
        val sum = a xor b
        val carry = (a and b) shl 1
        return if (carry != 0) {
            getSum(sum, carry)
        } else sum
    }
}