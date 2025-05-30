package Backtracking
/*
Question
Given a collection of numbers, nums,
that might contain duplicates, return all possible unique permutations in any order.
Answer
same as LC 46 .
for unique
each pos - we swap with remaining elements i.e index i
now remaining elements i.e elements at different i can be duplicate.
so we just check if element at i is seen previously - we do this for each pos
 */

fun permuteUnique(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val totalSize = nums.size

    fun dfs(pos:Int){
        if(pos == totalSize){
            result.add(nums.copyOf().toList())
            return
        }
        val visited = HashSet<Int>()
        for(i in pos until totalSize){
            if(nums[i] in visited)
                continue
            visited.add(nums[i])
            nums.swap(i,pos)
            dfs(pos+1)
            nums.swap(i,pos)
        }
    }
    dfs(0)
    return result
}

fun main() {
    val nums = intArrayOf(1, 1, 2) // Example input with duplicates
    val permutations = permuteUnique(nums) // Call the function

    // Print all unique permutations
    println("Unique permutations of ${nums.toList()}:")
    for (perm in permutations) {
        println(perm)
    }
}