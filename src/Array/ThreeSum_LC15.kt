package Array

fun main() {
    println(ThreeSum().threeSum(intArrayOf(-1,0,1,2,-1,-4)))
}
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for(i in 0 until nums.size - 2){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                var low = i + 1
                var high = nums.size - 1
                val sum = 0 - nums[i]
                while(low < high){
                    when{
                        nums[i] + nums[low] + nums[high] == 0 -> {
                            result.add(listOf(nums[i], nums[low], nums[high]))
                            while(low < high && nums[low] == nums[low + 1]) low++
                            while(low < high && nums[high] == nums[high - 1]) high--
                            low++
                            high--
                        }
                        nums[i] + nums[low] + nums[high] < 0 -> low++
                        else -> high--
                    }
                }
            }
        }
        return result
    }
}