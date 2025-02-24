package Array

fun main() {
    println(MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"))
}
class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        val targetMap = mutableMapOf<Char, Int>()
        val windowMap = mutableMapOf<Char, Int>()
        var result = ""
        for (c in t) {
            targetMap[c] = targetMap.getOrDefault(c, 0) + 1
        }
        var left = 0

        var totalMatches = 0
        for(right in 0 until s.length){
//            println(s.substring(left, right))
            if (targetMap.containsKey(s[right])) {
                windowMap[s[right]] = windowMap.getOrDefault(s[right], 0) + 1
                if(windowMap[s[right]] == targetMap[s[right]]){
                    totalMatches++
                }
            }

            while(totalMatches == targetMap.size){
                if(result.isEmpty() || result.length > right - left + 1){
//                    println(right)
//                    println(totalMatches)
//                    println(targetMap)
//                    println(s[left])
                    result = s.substring(left, right+1)
                }
                if(targetMap.containsKey(s[left])){

                    if(windowMap[s[left]]!! == targetMap[s[left]]!!)
                    totalMatches--
                    windowMap[s[left]] = windowMap[s[left]]!! - 1
                }
                left++

            }
        }
        return result
    }

}
