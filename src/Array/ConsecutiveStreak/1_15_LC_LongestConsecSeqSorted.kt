package Array.ConsecutiveStreak

/*
Given a sorted array of integers nums (may contain duplicates),
return the length of the longest consecutive sequence of distinct integers.
For example: [1, 1, 2, 2, 3, 4, 4, 5] → longest streak is [1,2,3,4,5] → length = 5
*/

class LongestConsecSeqSorted {

    /**
     * Returns the length of the longest consecutive sequence of distinct integers
     * in a sorted array that may contain duplicates.
     */
    fun getLongestConsecSeq(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var currentLength = 1      // Tracks current streak length
        var maxLength = 1          // Tracks maximum streak length found

        for (i in 1 until nums.size) {
            when {
                nums[i] - nums[i - 1] == 1 -> {
                    // Consecutive distinct number → extend current streak
                    currentLength++
                }
                nums[i] == nums[i - 1] -> {
                    // Duplicate → ignore, don't reset or extend streak
                }
                else -> {
                    // Break in sequence → reset current streak
                    currentLength = 1
                }
            }
            // Update max streak length
            maxLength = maxOf(maxLength, currentLength)
        }

        return maxLength
    }
}

/**
 * Main function to run and test the LongestConsecSeqSorted class.
 */
fun main() {
    val solver = LongestConsecSeqSorted()

    val test1 = intArrayOf(1, 1, 2, 2, 3, 4, 4, 5)
    val test2 = intArrayOf(1, 1, 1)
    val test3 = intArrayOf(1, 3, 3, 4, 5, 7, 8, 9, 10)
    val test4 = intArrayOf(5)

    println("Test 1 Output: ${solver.getLongestConsecSeq(test1)}") // 5
    println("Test 2 Output: ${solver.getLongestConsecSeq(test2)}") // 1
    println("Test 3 Output: ${solver.getLongestConsecSeq(test3)}") // 4
    println("Test 4 Output: ${solver.getLongestConsecSeq(test4)}") // 1
}
