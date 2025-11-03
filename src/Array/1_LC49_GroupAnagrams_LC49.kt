package Array
/*
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.
we make output hash with key as alphabet frequency array and value as list of the strings with same frequency array

 */
fun main() {
    println(GroupAnagrams.group(arrayOf("eat","tea","tan","ate","nat","bat")))
}
class GroupAnagrams {
    companion object{
        fun getArr(input:String):List<Int>{
            if(input.isEmpty())
                return MutableList(26) { 0 }
            val output = MutableList(26) { 0 }
            for (myChar in input){
                output[myChar - 'a'] += 1
            }
            return output
        }
        fun group(strs: Array<String>): List<List<String>> {
        val outputHash = hashMapOf<List<Int>,MutableList<String>>()
        for(myStr in strs){
            val myStrArr = getArr(myStr)
            val myList = outputHash.getOrPut(myStrArr, { mutableListOf<String>() })

                myList.add(myStr)
        }

            val outputList = mutableListOf<List<String>>()
            for(myList in outputHash.values){
                outputList.add(myList)
            }
            return outputList.toList()
        }
    }
}