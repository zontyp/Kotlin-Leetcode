package DP

fun main() {
    val a = intArrayOf(1,3,4,5,3)
    println(HouseRobber2().rob(a))
}
class HouseRobber2 {
    fun houseRobber(nums: IntArray, start: Int, end: Int): Int {
        var ago2 = 0
        var ago1 = 0
        for (i in start..end){
            val newMax = maxOf(ago2 + nums[i], ago1)
            ago2 = ago1
            ago1 = newMax
        }
        return ago1
    }
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]
        return maxOf(houseRobber(nums, 0, nums.size - 2), houseRobber(nums, 1, nums.size - 1))
    }
}