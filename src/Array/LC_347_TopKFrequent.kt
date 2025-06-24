package Array
/*
https://leetcode.com/problems/top-k-frequent-elements/submissions/1673866370/
LC 347
Given an integer array nums and an integer k,
return the k most frequent elements. You may return the answer in any order.
make frequency map
make a list with numbers of each frequency
then add to result from end of list to beginning.


 */
// Function to return the k most frequent elements from the input array
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    // Step 1: Count frequency of each number using a hashmap
    val frequencyMap = mutableMapOf<Int,Int>()
    val result = mutableListOf<Int>()
    for(num in nums){
        frequencyMap[num] = frequencyMap.getOrDefault(num,0) + 1
    }
    // Step 2: Create buckets where index = frequency,
    // and each bucket stores a list of numbers with that frequency
    val buckets = List(nums.size + 1){ mutableListOf<Int>() }
    for((num,freq) in frequencyMap){
        buckets[freq].add(num)
    }
    // Step 3: Traverse buckets from highest frequency to lowest
    // and collect the top k frequent elements
    for(i in buckets.size - 1 downTo 0){
        for(num in buckets[i]){
            result.add(num)
            if(result.size == k)
                return result.toIntArray()
        }
    }

    // Fallback return (in case k == nums.size)
    return result.toIntArray()
}

// Test function
fun main() {
    val result = topKFrequent(intArrayOf(1, 1, 2, 2, 2, 3, 3, 3), 2)
    println(result.joinToString())  // Output example: 3,2 or 2,3
}
