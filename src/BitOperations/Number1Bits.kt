package BitOperations

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