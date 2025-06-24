package Array
/*
https://leetcode.com/problems/product-of-array-except-self/description/
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

prodnums[i] = lprod[i] * rprod[i]
 */
fun main() {
    ProductArrExceptSelf().productExceptSelf(intArrayOf(1,2,3,4))
}
class ProductArrExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        var curr = 1
        val lProd = IntArray(nums.size)
        val rProd = IntArray(nums.size)

        val output = IntArray(nums.size)
//        output.forEach { println(it) }
        for(i in 0 until nums.size){
            lProd[i] = curr
            curr *= nums[i]
        }
        curr = 1
        for(i in nums.size - 1 downTo 0){
            rProd[i] = curr
            curr *= nums[i]
        }
        for(i in 0 until nums.size){
            output[i] = lProd[i] * rProd[i]
        }
//        output.forEach { println(it) }
        return output
    }
}