package BinarySearch

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