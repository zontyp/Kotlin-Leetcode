package Array


fun main() {
    println(ValidAnagram().isAnagram("anagram","nagaram"))
}
class ValidAnagram {
    fun isAnagram(s:String,t:String):Boolean{
        val sHashMap = hashMapOf<Char,Int>()
        val tHashMap = hashMapOf<Char,Int>()
        for (myChar in s){
            sHashMap.computeIfAbsent(myChar){0}
            sHashMap[myChar] = sHashMap[myChar]!! + 1
        }
        for (myChar in t){
            tHashMap.computeIfAbsent(myChar){0}
            tHashMap[myChar] = tHashMap[myChar]!! + 1
        }

        return sHashMap == tHashMap
    }
}