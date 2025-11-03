package Array.TwoPointer.ReadWrite

/*
https://leetcode.com/problems/move-zeroes/description/
Given an integer array nums, move all 0's to the end of it
while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
related problems => 26,27

solution :

read , write two pointer

r ptr will read
l ptr will write

l ptr will be trapped / paused at 0 values

when current value is 0 {
increment r
dont increment l
}
when current value is not 0 {
incr r , incr l
if l != r
swap l , r
}
 */

fun moveZeroes(nums: IntArray): Unit {
    var l = 0 // write pointer: position where next non-zero should be placed

    // iterate using r as read pointer
    for (r in nums.indices) {
        if (nums[r] != 0) {
            if (l != r) {
                // swap non-zero element at r with element at l (which is either 0 or already processed)
                nums[l] = nums[r]
                nums[r] = 0
            }
            l++ // move l to the next write position
        }
    }
}

fun main() {
    val a = intArrayOf(1, 1, 0, 0, 4, 5, 6, 0)
    moveZeroes(a)
    a.forEach { println(it) } // Output will be: 1 1 4 5 6 0 0 0
}
