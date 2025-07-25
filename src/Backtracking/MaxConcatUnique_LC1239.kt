/*
LC 1239
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/

 You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.


 find all subsequences and take only the one that maintains unique property
 find all subsequences with for loop


 */

package Backtracking

import kotlin.math.max

fun main() {
    MaxConcatUnique_LC1239().maxLength(listOf("abc","b","d")).let { println(it) }
}
class MaxConcatUnique_LC1239 {
    fun maxLength(arr: List<String>): Int {
        val inputStrings = arr.filter {
            it.length == it.toSet().size
        }
        if (inputStrings.size == 0)
            return 0
        val endIndex = inputStrings.size - 1
        var maxLength = 0
        fun dfs(pos:Int,currentSet:Set<Char>){
            maxLength = max(maxLength,currentSet.size)

            //generate all subsets
            for(i in pos..endIndex){
                val newSet = inputStrings[i].toSet()
                //take only if eligible
                if(newSet.intersect(currentSet).isEmpty()){
                    dfs(i+1,currentSet.union(newSet))
                }
            }
        }
        dfs(0, emptySet())
        return maxLength
    }
}