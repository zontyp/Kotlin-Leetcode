/*
Question
https://leetcode.com/problems/combination-sum/description/

Given an array of distinct integers candidates and a target
integer target, return a list of all unique combinations of
candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an
unlimited number of times. Two combinations are unique
if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of
unique combinations that sum up to target is less than
150 combinations for the given input.
 */
/*
solution
take and add to current sum
not take and dont add to current sum
same as subsequences
better to sort input array as we prune the tree - eliminate higher sums quickly

//doubt - why to sort array ?
why we need
currentSum > target and currentSum + candidates[index] > target
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val leafList = mutableListOf<Int>()
    val result = mutableListOf<List<Int>>()
    val inputSize = candidates.size
    candidates.sort()
    fun dfs(index:Int,currentSum:Int){
        if(currentSum == target){
            result.add(leafList.toList())
            return
        }
        //previous current sum was smaller and adding current makes it larger then no point in proceeding
        //IF WE DONT TAKE CURRENT ELEMENT - no point in taking any subsequent element as well 
        //current sum has become greater - no point in proceeding
        if(index == inputSize || currentSum + candidates[index] > target)
            return

        leafList.add(candidates[index])
        dfs(index,currentSum + candidates[index])
        leafList.removeLast()
        dfs(index+1,currentSum)

    }
    dfs(0,0)
    return result
}
fun main() {
    val candidates = intArrayOf(2, 3, 5)
    val target = 8

    println("Candidates: ${candidates.joinToString(", ")}")
    println("Target: $target")

    val result = combinationSum(candidates, target)

    println("Combinations that sum up to $target:")
    for (combo in result) {
        println(combo)
    }
}
