package DP

class LongestIncrSubseqDP {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        // dp[i] represents the length of the LIS ending at index i
        val dp = IntArray(nums.size) { 1 }

        // For each position, check all previous positions
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                // If current number is greater than the previous number
                if (nums[i] > nums[j]) {
                    // Update if we found a longer subsequence
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }

        // Return the maximum value in dp array
        return dp.maxOrNull() ?: 1
    }
}