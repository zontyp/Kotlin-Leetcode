package BitOperations
/*
idea:
sum - x exor y
carry = (x and y ) shl 1
keep repeating till carry becomes 0
x = sum , y = carry

use n + 1 bits minimum
start with 4 bits



 */
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