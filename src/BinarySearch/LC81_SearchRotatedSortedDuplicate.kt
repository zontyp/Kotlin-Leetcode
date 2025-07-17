package BinarySearch
/*LC 81
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
idea:
the only problem case with duplicates is
nums[low] == nums[mid] == nums[high]
so just trim / ignore this case
and try to come to a case where we can detect the sorted part is either left or right part

how to think if why this problem case could occur
imagine 1,2 and a long list of 3's
and rotation takes place after the first 3
3,3,3....,1,2,3
now nums[low] == nums[mid] == nums[high]

 */
fun main() {
    SearchRotatedSortedDuplicate_LC81().search(intArrayOf(1,0,1,1,1),0).let{ println(it) }
}
class SearchRotatedSortedDuplicate_LC81 {
    fun search(nums: IntArray, target: Int): Boolean {
        var low = 0
        var high = nums.size - 1
        while(low <= high){
            var mid = low + (high - low) / 2
            if(nums[mid] == target) { return true}
            //below if is for duplicate case
                if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
//                    println("inside")
//                    println(low)
//                    println(high)
//                    println(nums[low])
//                    println(nums[high])
//                    println(nums[mid])
                    low++
                    high--
                    continue
                }

                if(nums[low] <= nums[mid])  {
//                    println("outside")
                    //first part is sorted
                    if(target >= nums[low] && target < nums[mid]){
                        high = mid - 1
                    }
                    else{
                        low = mid + 1
                    }
                }
                else  {
//                    println("outside1")
                    //second part is sorted
                    if(target > nums[mid] && target <= nums[high]){
                        low = mid + 1
                    }
                    else{
                        high = mid - 1
                    }
                }



        }
        return false
    }
}