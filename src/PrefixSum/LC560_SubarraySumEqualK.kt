package PrefixSum
/*
LC560
https://leetcode.com/problems/subarray-sum-equals-k/description/
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

idea:
why we cant use sliding window :
sliding window works on concept that
expanding window increases the sum
shrinking window decreases sum
this works only when numbers are increasing or decreasing
in this problem - negative numbers , 0 can exist
so we cant use sliding window.

Let's look at what the sliding window technique assumes:

When the sum becomes greater than k, shrink the window from the left.
When the sum is less than k, grow the window to the right.

❗ But if the array has negative numbers...
Shrinking the window may increase the sum.
Growing the window may decrease the sum.

this problem can be solved by prefix sum
if your balance is 1000 today and you wish to
find between which dates you have gained 200 ruppees

you need to count those dates when your balance was 800

suppose your balance on 30th is 1000
and your balance on 25th is 800
how much you gained from 26th to 30th = 200

suppose your balance on 20th was also 800
how much you gained from 21st to 30th = 200
 */
class LC560_SubarraySumEqualK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixSumsCountMap = mutableMapOf<Int, Int>()
        prefixSumsCountMap[0] = 1  // base case: sum 0 has occurred once before starting

        var currentPrefixSum = 0
        var subarrayCountRes = 0

        for (num in nums) {
            // update prefix sum as we iterate
            currentPrefixSum += num

            // check if we've seen a prefix sum that would give us a subarray sum of k
            val countOfPrevPrefix = prefixSumsCountMap.getOrDefault(currentPrefixSum - k, 0)
            subarrayCountRes += countOfPrevPrefix

            // update count of the current prefix sum in the map
            prefixSumsCountMap[currentPrefixSum] = prefixSumsCountMap.getOrDefault(currentPrefixSum, 0) + 1
        }

        return subarrayCountRes
    }
}

// ✅ Main function to test the logic
fun main() {
    val obj = LC560_SubarraySumEqualK()

    val nums1 = intArrayOf(1, 1, 1)
    val k1 = 2
    println("Subarrays with sum $k1: ${obj.subarraySum(nums1, k1)}") // Expected: 2

    val nums2 = intArrayOf(1, 2, 3)
    val k2 = 3
    println("Subarrays with sum $k2: ${obj.subarraySum(nums2, k2)}") // Expected: 2

    val nums3 = intArrayOf(1, -1, 1, 1, 1)
    val k3 = 2
    println("Subarrays with sum $k3: ${obj.subarraySum(nums3, k3)}") // Expected: 4
}
