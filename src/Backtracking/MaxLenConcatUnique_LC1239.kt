package Backtracking

import kotlin.math.max

fun maxLength(arr: List<String>): Int {
    val uniqueStrings = mutableListOf("")
    var maxLen = 0
    for(inputString in arr){
        val currentUniqueStrList = uniqueStrings.toList()
        for(existing in currentUniqueStrList){
            val candidate = existing + inputString
            if(candidate.length == candidate.toSet().size){
                uniqueStrings.add(candidate)
                maxLen = max(maxLen,candidate.length)
            }

        }
    }
    return maxLen
}
fun main() {
    maxLength(listOf("abc","b","d")).let { println(it) }
}