package SlidingWindow
/*
https://leetcode.com/problems/maximum-average-subarray-i/description/

Problem:
Given an integer array `nums` and an integer `k`,
find the contiguous subarray of length `k` that has the maximum average value.

Return this value as a Double.
Any answer with a calculation error less than 1e-5 will be accepted.

idea:
sliding window
first find for first 3 elements , then increase window by size  1
*/

class LC643_MaxAvgSubArr {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var windowSum = 0.0
        var maxAvgResult = Double.MIN_VALUE

        // Step 1: Calculate the sum of the first window of size k
        for (i in 0 until k) {
            windowSum += nums[i]
        }

        // Step 2: Initialize max average with the first window's average
        maxAvgResult = windowSum / k

        // Step 3: Slide the window one element at a time
        for (i in k until nums.size) {
            // Remove the element that is going out of the window
            // Add the element that is coming into the window
            windowSum = windowSum - nums[i - k] + nums[i]

            // Calculate the new average and update maxAvgResult if it's larger
            maxAvgResult = maxOf(windowSum / k, maxAvgResult)
        }

        return maxAvgResult
    }
}

// ✅ Main function to test the solution
fun main() {
    val solver = LC643_MaxAvgSubArr()

    // Test Case 1
    val nums1 = intArrayOf(1, 12, -5, -6, 50, 3)
    val k1 = 4
    val result1 = solver.findMaxAverage(nums1, k1)
    println("Max average of subarray of length $k1 is $result1")  // Expected: 12.75

    // Test Case 2
    val nums2 = intArrayOf(5, 5, 5, 5, 5)
    val k2 = 2
    val result2 = solver.findMaxAverage(nums2, k2)
    println("Max average of subarray of length $k2 is $result2")  // Expected: 5.0
}
