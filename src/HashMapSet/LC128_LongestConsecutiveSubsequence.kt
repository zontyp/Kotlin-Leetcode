package HashMapSet
/*
LC 128
https://leetcode.com/problems/longest-consecutive-sequence/description/
Given an unsorted array of integers nums,
 return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
idea:
we need to find start of sequence - if(!lookup.contains(n-1)){
and then check if next element is present
we need to avoid duplicates - so we use a set.
at each element - calculate current length and maxLength


 */
fun main() {
    println(LongestConsecutiveSubsequence_LC128().longestConsecutive(intArrayOf(0,3,2,5,4,6,1,1)))
}
class LongestConsecutiveSubsequence_LC128 {
    fun longestConsecutive(nums:IntArray):Int{
        var longest = 0
        val lookup = hashSetOf<Int>()
        for (n in nums){
            lookup.add(n)
        }
        for(n in lookup){
            if(!lookup.contains(n-1)){
                //start of sequence
                var length = 1
                while(lookup.contains(n + length)) {
                    length++
                }
                longest = Math.max(length,longest)
            }
        }
        return longest
    }

}