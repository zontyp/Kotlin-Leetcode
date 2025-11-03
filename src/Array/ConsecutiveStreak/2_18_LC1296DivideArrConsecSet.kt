package Array.ConsecutiveStreak
/*
LC 1296
https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
Given an array of integers nums and a positive integer k,
check whether it is possible to divide this array into
sets of k consecutive numbers.

Return true if it is possible. Otherwise, return false.

idea:
find the start of sequence
form the sequence
to find start of sequence - we need a tree map
 */
class LC1296DivideArrConsecSet {
    /**
     * Determines if the array can be divided into sets of k consecutive numbers.
     */
    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
        if (nums.size % k != 0) return false  // Early check: can't divide equally

        val freq = java.util.TreeMap<Int, Int>() // TreeMap to keep keys sorted
        for (num in nums) {
            freq[num] = freq.getOrDefault(num, 0) + 1
        }

        // Try to build groups starting from the smallest available key
        while (freq.isNotEmpty()) {
            val start = freq.firstKey() // Start of the current group

            // Try to build a sequence of k consecutive numbers
            for (i in 0 until k) {
                val curr = start + i

                // If a required number is missing, return false
                if (!freq.containsKey(curr)) return false

                // Decrease frequency; remove key if count becomes zero
                val count = freq[curr]!! - 1
                if (count == 0) {
                    freq.remove(curr)
                } else {
                    freq[curr] = count
                }
            }
        }

        return true
    }
}

/**
 * Main function to test LC1296DivideArrConsecSet
 */
fun main() {
    val solver = LC1296DivideArrConsecSet()

    val test1 = intArrayOf(1, 2, 3, 3, 4, 4, 5, 6)
    val test2 = intArrayOf(1, 2, 3, 4)
    val test3 = intArrayOf(1, 2, 3, 4, 5, 6)
    val test4 = intArrayOf(3, 3, 2, 2, 1, 1)
    val test5 = intArrayOf(1, 2, 3, 5, 6, 7, 8, 9)

    println("Test 1 Output: ${solver.isPossibleDivide(test1, 4)}") // true
    println("Test 2 Output: ${solver.isPossibleDivide(test2, 3)}") // false
    println("Test 3 Output: ${solver.isPossibleDivide(test3, 2)}") // true
    println("Test 4 Output: ${solver.isPossibleDivide(test4, 3)}") // true
    println("Test 5 Output: ${solver.isPossibleDivide(test5, 3)}") // false
}
