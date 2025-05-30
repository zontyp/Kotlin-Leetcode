package Backtracking
/*
Question
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.
 */
/* Solution
we use dfs
we apply dfs for every pos of the input array
we swap element at pos with all remaining elements
everytime dfs is called with a pos - we swap the element at pos with all remaining elements
so for every call to dfs - we have a for loop
for loop is to swap all remaining elements with current pos element
 */
fun IntArray.swap(x:Int,y:Int){
    this[x] = this[y].also{this[y] = this[x]}
}
fun permute(nums: IntArray): List<List<Int>> {
    val totalSize = nums.size
    val result = mutableListOf<List<Int>>()
    //at each pos - swap current pos element with remaining eleents
    fun dfs(pos:Int){
        //base case
        if(pos == totalSize){
            result.add(nums.copyOf().toList())
            return
        }
        //for [1,2,3] pos is 0,1,2. at each pos value we use for loop to swap current pos element with remaiing elements
        for (i in pos  until totalSize){
            nums.swap(i,pos)
            dfs(pos+1)
            nums.swap(i,pos)
        }
    }
    dfs(0)
    return result
}

fun main() {
    val nums = intArrayOf(1, 2, 3) // Example input
    val permutations = permute(nums) // Call the function
    // Print each permutation on a new line
    println("All permutations of ${nums.toList()}:")
    for (perm in permutations) {
        println(perm)
    }
}
