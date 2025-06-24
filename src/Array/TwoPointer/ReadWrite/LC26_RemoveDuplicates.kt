package Array.TwoPointer.ReadWrite
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
related problems => 27,283
 */
class LC26_RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        var l = 0
        var r = 0
        for(r in nums.indices){
            if(nums[r] != nums[l]){
                l++
                if(l!=r)
                    nums[l] = nums[r]
            }
            else{
                if(r - l <= 1)
                    l++
            }
        }
        return l+1
    }

}

fun main() {

}