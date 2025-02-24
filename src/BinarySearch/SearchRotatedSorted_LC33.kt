package BinarySearch

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
                nums[0] <= nums[mid] ->{
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