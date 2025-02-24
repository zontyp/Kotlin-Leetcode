package DP

import kotlin.math.max

fun main() {
    val a = intArrayOf(1,3,4,5,3)
    println(HouseRobber().rob(a))
}
class HouseRobber {
    fun rob(nums: IntArray): Int {
        var ago2 = 0
        var ago1 = 0
        for (money in nums){
            val newMax = max(ago2 + money, ago1)
            ago2 = ago1
            ago1 = newMax
        }
        return ago1
    }
}