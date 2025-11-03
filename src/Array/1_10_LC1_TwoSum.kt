package Array
//https://neetcode.io/problems/two-integer-sum
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/
 
fun main() {
    println(TwoSum.finder(intArrayOf(3,2,4),6).forEach { println(it) })
}
class TwoSum {
    companion object{
        fun finder(nums:IntArray,target:Int): IntArray {
            val lookup = hashMapOf<Int,Int>()
            for(i in 0 until nums.size){
                lookup.put(nums[i],i)
            }
            println(lookup)
            for(i in 0 until nums.size){
                val diff = target - nums[i]
                println(diff)
                if(lookup.containsKey(diff) && lookup.get(diff)!! != i){
                    return intArrayOf(i,lookup.get(diff)!!)
                }
            }
            return intArrayOf(0)
        }
    }
}