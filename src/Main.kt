fun main() {
    combinationSum(intArrayOf(1,4,2),3).let { println(it) }
}
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    var index = 0
    var n = candidates.size
    val result = mutableListOf<List<Int>>()
    val leafList = mutableListOf<Int>()
//    candidates.sort()
    fun dfs(index:Int,currentSum:Int){
        if(index == n || currentSum > target)
            return
        if(currentSum == target){
            result.add(leafList.toList())
            return
        }

        if(currentSum + candidates[index] > target)
            return
        leafList.add(candidates[index])
        dfs(index,currentSum + candidates[index])
        leafList.removeLast()
        dfs(index+1,currentSum)
    }
    dfs(0,0)
    return result
}
