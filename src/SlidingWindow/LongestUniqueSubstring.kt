package SlidingWindow
fun main() {
    LongestUniqueSubstring()
        .lengthOfLongestSubstring("abba")
        .let{ println(it) }
}
class LongestUniqueSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty())
            return 0
        var i = 0
        var j = 0
        var lookup = hashMapOf<Char,Int>()
        var result = Int.MIN_VALUE
        for(j in 0 until s.length){
            if(lookup.containsKey(s[j])){
//                println(s[j])
//                println(lookup.get(s[j]))
//                println(lookup.get(s[j])!!+1)
                i = Math.max(lookup.get(s[j])!!+1,i)
            }
            lookup.put(s[j],j)
            result = Math.max(result,j-i+1)
//            println("---------------")
//            println(s[i]..s[j])
//            println(i)
//            println(j)
//            println(result)
//            println("---------------")
        }
        return result
    }
}