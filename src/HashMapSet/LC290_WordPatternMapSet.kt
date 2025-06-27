package HashMapSet
/*
LC 290
https://leetcode.com/problems/word-pattern/
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.

idea:
check if current alphabet is mapped or no
if its mapped - check the mapping
if alphabet is  not mapped - check if the word is already used - as we need one to one mapping
 */
class LC290_WordPatternMapSet {
    fun wordPattern(pattern: String, s: String): Boolean {
        val stringWordList = s.split(" ") // split string into words
        val charWordMap = mutableMapOf<Char,String>() // stores char-to-word mapping
        val usedWords = mutableSetOf<String>() // stores already mapped words

        // if lengths differ, they can't follow the same pattern
        if(pattern.length != stringWordList.size)
            return false

        // iterate through both pattern and words together
        for (i in pattern.indices){
            val currentChar = pattern[i]
            val currentWord = stringWordList[i]

            if(currentChar in charWordMap){
                //wrong mapping
                if(charWordMap[currentChar] != currentWord)
                    return false // current mapping doesn't match word
            }
            else{
                //same word already mapped/exists
                if(currentWord in usedWords)
                    return false // violates one-to-one mapping

                //add new char mapping
                charWordMap[currentChar] = currentWord

                //add new word to used word
                usedWords.add(currentWord) // mark this word as already mapped
            }
        }

        // all mappings are consistent
        return true
    }
}
