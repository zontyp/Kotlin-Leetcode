package BinarySearch

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