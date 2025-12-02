package BinarySearch
/*
LC153
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
you can rotate in 3 ways:
at the midpoint
from right of midpoint
from left of midpoint

after rotating in all 3 ways
check nums[low] and nums[mid]
if nums[low] is less or equal - left part is sorted
else right part is sorted
take the minimum from the sorted part and then ignore the sorted part
we just need minimum from sorted part in the current iteration
 */
fun main() {
    MinRotatedSortedArr_LC153().findMin(intArrayOf(3,4,5,2)).let { println(it) }
}
class MinRotatedSortedArr_LC153 {
    fun findMin(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1
        var minElem = Int.MAX_VALUE
        while(low <= high){
            var mid = low + (high - low) / 2
            when{
                nums[low] <= nums[mid]->{
                    //left part is sorted
                    minElem = Math.min(nums[low],minElem)
                    low = mid+1
                }
                else ->{
                    //right part is sorted
                    minElem = Math.min(nums[mid],minElem)
                    high = mid - 1

                }
            }
        }
        return minElem
    }
}