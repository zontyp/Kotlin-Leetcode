package Array.TwoPointer.ReadWrite

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */

class LC80_RemoveDupeTwoPlus {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size // base case: always allowed
        var l = 2
        for(r in 2 until nums.size){
            //is this element the third duplicate
            if(nums[r] != nums[l-2]){
                nums[l] = nums[r]
                l++
            }
        }
        return l
    }
}

fun main() {

}