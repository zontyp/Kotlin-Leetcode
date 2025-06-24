package Array.ConsecutiveStreak

/**
 * LeetCode 128: Longest Consecutive Sequence (for unsorted arrays).
 *
 * Given an unsorted array of integers, return the length of the longest sequence
 * of consecutive elements (regardless of order), without duplicates in the count.
 */
class LC128_LongestConsecSecUnsorted {

    /**
     * Returns the length of the longest consecutive sequence in the input array.
     * Example: [100, 4, 200, 1, 3, 2] → Longest sequence is [1, 2, 3, 4] → length = 4
     */
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val lookup = nums.toHashSet() // shortcut to fill HashSet
        var maxLength = 1 // Track the max length of any sequence

        // Iterate through all numbers in the set
        for (num in lookup) {
            // Only start counting if it's the start of a new sequence
            if (!lookup.contains(num - 1)) {
                var currentLength = 1
                var currentNum = num

                // Count how many consecutive numbers exist starting from 'num'
                while (lookup.contains(currentNum + 1)) {
                    currentNum++
                    currentLength++
                }

                // Update max length if this sequence is longer
                maxLength = maxOf(maxLength, currentLength)
            }
        }

        return maxLength
    }
}

/**
 * Main function to test LC128_LongestConsecSecUnsorted
 */
fun main() {
    val solver = LC128_LongestConsecSecUnsorted()

    val test1 = intArrayOf(100, 4, 200, 1, 3, 2)
    val test2 = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
    val test3 = intArrayOf()
    val test4 = intArrayOf(5)
    val test5 = intArrayOf(9, 1, 4, 7, 3, -1, 0, 5, 8, -2, 6)

    println("Test 1 Output: ${solver.longestConsecutive(test1)}") // 4 → [1,2,3,4]
    println("Test 2 Output: ${solver.longestConsecutive(test2)}") // 9 → [0 to 8]
    println("Test 3 Output: ${solver.longestConsecutive(test3)}") // 0
    println("Test 4 Output: ${solver.longestConsecutive(test4)}") // 1
    println("Test 5 Output: ${solver.longestConsecutive(test5)}") // 7 → [-2 to 4]
}
