package BitOperations

class SumTwoIntegersIterative {
    fun getSum(a:Int,b:Int):Int{
        var x = a
        var y = b
        while(y!=0){
            val sum = x xor y
            val carry = (x and y) shl 1
            x = sum
            y = carry
        }
        return x
    }
}