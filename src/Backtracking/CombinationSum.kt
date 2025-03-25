package Backtracking

class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val leafList = mutableListOf<Int>()
        val n = candidates.size
        candidates.sort()
        fun dfs(index:Int,currentSum:Int){

            if(currentSum == target){
                result.add(leafList.toList())
                return
            }
            if(index == n || currentSum > target)
                return
            if (currentSum + candidates[index] > target) {
                return
            }

            leafList.add(candidates[index])
            dfs(index,currentSum + candidates[index])
            leafList.removeLast()
            dfs(index+1,currentSum)
        }
        dfs(0,0)
        return result

    }
}