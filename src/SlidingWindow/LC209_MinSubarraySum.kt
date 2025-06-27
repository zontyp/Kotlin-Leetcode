package SlidingWindow
/*
LC 209
https://leetcode.com/problems/minimum-size-subarray-sum/description/
Given an array of positive integers nums and a positive integer target,
 return the minimal length of a subarray whose sum is greater
 than or equal to target. If there is no such subarray, return 0 instead.
 */
class LC209_MinSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var l = 0
        var windowSum = 0
        var minWindowLenRes = Int.MAX_VALUE
        for(r in nums.indices){
            windowSum += nums[r]
            while(windowSum >= target) {
                minWindowLenRes = minOf(minWindowLenRes, r - l + 1)
                windowSum -= nums[l]
                l++
            }
        }
        if(minWindowLenRes == Int.MAX_VALUE)
            return 0
        else
        return minWindowLenRes
    }
}