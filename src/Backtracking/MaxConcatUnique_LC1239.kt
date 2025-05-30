

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