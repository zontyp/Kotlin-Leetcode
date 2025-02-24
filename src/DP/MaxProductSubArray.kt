package DP

fun main() {
    val a = intArrayOf(2,3,-2,4)
    println(MaxProductSubArray().maxProduct(a))
}
class MaxProductSubArray {
    fun maxProduct(nums: IntArray): Int {
        var maxProduct = nums[0]
        var minProduct = nums[0]
        var result = nums[0]
        for(i in 1 until nums.size){
            if(nums[i] < 0){
                maxProduct = minProduct.also { minProduct = maxProduct }
            }
            maxProduct = maxOf(nums[i], maxProduct * nums[i])
            minProduct = minOf(nums[i], minProduct * nums[i])
            result = maxOf(result, maxProduct)
        }

        return result
    }
}