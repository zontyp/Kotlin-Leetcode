package HashMapSet
/*
LC 219
Given an integer array nums and an integer k,
 return true if there are two distinct indices i and j
 in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
class LC219_ContainsDuplicate2 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val lookupMap = mutableMapOf<Int,Int>()
        for(i in nums.indices){
            if(nums[i] in lookupMap){
                val lastNumPos = lookupMap[nums[i]]
                if (i - lastNumPos!! <= k)
                    return true
                lookupMap.put(nums[i],i)

            }
            else{
                lookupMap.put(nums[i],i)
            }
        }
        return false
    }
}