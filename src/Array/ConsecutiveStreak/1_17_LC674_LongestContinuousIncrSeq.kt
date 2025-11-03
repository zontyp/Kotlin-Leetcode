package Array.ConsecutiveStreak
/*
LC 674
https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
Given an unsorted array of integers nums, return the length of the longest
continuous increasing subsequence (i.e. subarray).
The subsequence must be strictly increasing.

A continuous increasing subsequence is defined by two indices
l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]]
and for each l <= i < r, nums[i] < nums[i + 1].
idea:

check with previous
adjust current length and max length
 */
class LC674_LongestContinuousIncrSeq {

    /**
     * Returns the length of the longest continuous increasing subsequence (LCIS) in the array.
     */
    fun findLengthOfLCIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var currentLength = 1  // Length of the current increasing streak
        var maxLength = 1      // Maximum streak found so far

        // Iterate over the array from index 1 to end
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                // If current number is greater than previous, continue the streak
                currentLength++
            } else {
                // Else, reset the current streak length
                currentLength = 1
            }
            // Update max length if current streak is longer
            maxLength = maxOf(maxLength, currentLength)
        }

        return maxLength
    }
}

// Main function to test the code
fun main() {
    val solver = LC674_LongestContinuousIncrSeq()

    val test1 = intArrayOf(1, 3, 5, 4, 7)
    val test2 = intArrayOf(2, 2, 2, 2, 2)
    val test3 = intArrayOf(1, 2, 3, 4, 5, 6)
    val test4 = intArrayOf(5)
    val test5 = intArrayOf(1, 3, 5, 7, 0, 1, 2, 3)

    println("Test 1: ${solver.findLengthOfLCIS(test1)}") // Output: 3
    println("Test 2: ${solver.findLengthOfLCIS(test2)}") // Output: 1
    println("Test 3: ${solver.findLengthOfLCIS(test3)}") // Output: 6
    println("Test 4: ${solver.findLengthOfLCIS(test4)}") // Output: 1
    println("Test 5: ${solver.findLengthOfLCIS(test5)}") // Output: 4
}
