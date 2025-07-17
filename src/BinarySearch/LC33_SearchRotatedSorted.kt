package BinarySearch
/*
LC 33
https://leetcode.com/problems/search-in-rotated-sorted-array/description/
idea:
we need to search target element
we know that when array is rotated :
either left part is sorted or right part is sorted - in all
3 types of rotation - before mid point , after mid point , at the mid point
so we just check nums[low] <= nums[mid] to check if left part is sorted
then we simply check if target is within range of the sorted part
1) first check if left part is sorted or right part is sorted
2) then check if target is in range of the sorted part
 */
fun main() {
    SearchRotatedSorted_LC33().search(intArrayOf(1,2,3),1).let{ println(it) }
}
class SearchRotatedSorted_LC33 {
    fun search(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while(low <= high){
            var mid = low + (high - low)/2
            when{
                nums[mid] == target -> return mid
                nums[low] <= nums[mid] ->{
                    //left part is sorted
                    if(target >= nums[low] && target < nums[mid])
                        high = mid - 1
                    else
                        low = mid + 1
                }
                else -> {
//                    right part is sorted
                    if(target > nums[mid] && target <= nums[high])
                        low = mid + 1
                    else
                        high = mid - 1

                }
            }
       }
        return -1
    }
}