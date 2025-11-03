package HashMapSet
/*
LC 219
https://leetcode.com/problems/contains-duplicate-ii/

Given an integer array nums and an integer k,
return true if there are two distinct indices i and j
in the array such that nums[i] == nums[j] and abs(i - j) <= k.

idea: store number and its position in a map
then check position diff when same number appears again
 */
class LC219_ContainsDuplicate2 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val lookupMap = mutableMapOf<Int, Int>() // stores num → last seen index

        for (i in nums.indices) {
            if (nums[i] in lookupMap) {
                //duplicate appears
                val lastNumPos = lookupMap[nums[i]]
                // check position diff
                if (i - lastNumPos!! <= k)
                    return true
                // update to latest position
                lookupMap[nums[i]] = i
            } else {
                //store unique number in lookup
                lookupMap[nums[i]] = i
            }
        }

        // no such pair found
        return false
    }
}

fun main() {
    val checker = LC219_ContainsDuplicate2()

    // ✅ Test 1: Valid duplicate within distance
    println(checker.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3)) // true

    // ❌ Test 2: Duplicate exists but not within distance
    println(checker.containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1)) // true

    // ❌ Test 3: No duplicates
    println(checker.containsNearbyDuplicate(intArrayOf(1, 2, 3, 4, 5), 2)) // false

    // ✅ Test 4: Multiple duplicates but only some are within range
    println(checker.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2)) // false

    // ✅ Edge Case: k = 0 means no valid pair can exist
    println(checker.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 0)) // false
}
