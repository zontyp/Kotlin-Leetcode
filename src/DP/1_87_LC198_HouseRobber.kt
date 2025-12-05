package DP
/*
LC 198

🤔 “Should I rob this house or skip it?”
You only have two choices at each house:

Rob this house → But then you must skip the previous one →
You add money at this house + best we could do till two houses ago.

Skip this house → Just take the best we could do till previous house.
import kotlin.math.max

--- Big Idea ---
at each house - there are only two possible results
and we calculate both of them

🔁 At each house, there are two possibilities:
Rob this house
→ Then you must skip the previous house
→ Total = money at current house + best till (i - 2)

Skip this house
→ Just take best till (i - 1)
*/


fun main() {
    val a = intArrayOf(1,3,4,5,3)
    println(HouseRobber().rob(a))
}
class HouseRobber {
    fun rob(nums: IntArray): Int {
        var ago2 = 0
        var ago1 = 0
        for (money in nums){
            val newMax = maxOf(ago2 + money, ago1)
            ago2 = ago1
            ago1 = newMax
        }
        return ago1
    }
}