/*
Question
Given an array of distinct integers candidates and a target integer target,
find all unique combinations where the sum of numbers equals target.
take element of candidate any number of times
 */
/*
solution
take and add to current sum
not take and dont add to current sum
same as subsequences
better to sort input array as we prune the tree - eliminate hiher sums quickly
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
        if(currentSum > target || index == inputSize || currentSum + candidates[index] > target)
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
