package Backtracking
/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
Question :
Given a string containing digits from 2-9 inclusive, return all possible
letter combinations that the number could represent.
Return the answer in any order.

Answer :
suppose we get input "23"
2 positions need to be filled
we use dfs
job of dfs 0 is to fill the first position .
job of dfs 1 is to fill the second position .

in dfs 0 , we have three choices - pick a or b or c - this work of taking 3 choices will be done by for loop
so for loop will be inside dfs
so dfs repeats for pos
for loop repeats for i variable (or ch in this case)
dfs 1 returns for i = 0
then we move to dfs 1 for i = 1
when dfs 1 returns for i = 1
then we move to dfs 1 for i = 2
and then we return to dfs 0 for i = 0 , 1, 2

we find all possible subsets .
at each position - we take / not take each character

 */
fun letterCombinations(digits: String): List<String> {
    if(digits == "")
        return listOf()
    val digitLettersMap = mutableMapOf<Int,String>()
    digitLettersMap.put(2,"abc")
    digitLettersMap.put(3, "def")
    digitLettersMap.put(4, "ghi")
    digitLettersMap.put(5, "jkl")
    digitLettersMap.put(6, "mno")
    digitLettersMap.put(7, "pqrs")
    digitLettersMap.put(8, "tuv")
    digitLettersMap.put(9, "wxyz")
    val leafString = StringBuilder()
    val result = mutableListOf<String>()
    fun dfs(pos:Int){
        if(pos>=digits.length) {
            result.add(leafString.toString())
            return
        }
        val currentDigit = digits[pos].toString().toInt()
        val currentStr = digitLettersMap.get(currentDigit)!!
        for(ch in currentStr){
            leafString.append(ch)
            dfs(pos+1)
            leafString.deleteCharAt(leafString.length - 1) // Backtrack

        }

        println(currentDigit)
        println(currentStr)
    }
    dfs(0)
    return result
}
fun main() {
    letterCombinations("23").let{ println(it) }
}