package SlidingWindow

fun main() {
    LongestRepCharReplacement()
        .characterReplacement("AABABBA",1)
        .let{ println(it) }
}
class LongestRepCharReplacement {
    fun characterReplacement(s: String, k: Int): Int {
        var i = 0
        var maxF = 0
        val lookup = hashMapOf<Char,Int>()
        var result = 0
        for (j in 0 until s.length){
            val newFreq = (lookup.get(s[j])?:0) + 1
            lookup.put(s[j],newFreq)
            maxF = Math.max(maxF,newFreq)
//            println(maxF)
            while((j - i + 1) - maxF > k){
//                println(i)
//                println(j)
//                println(s[i])
//                println(lookup.get(s[i]))
                val oldFreq = lookup.get(s[i])
                lookup.put(s[i] , oldFreq!! - 1)
                i++
            }
            result = Math.max(result,j - i + 1)
        }
        return result
    }
}