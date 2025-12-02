package Trie
/*
LC 211
https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

Design a data structure that supports adding new words and finding
if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the
data structure that matches word or false otherwise.
 word may contain dots '.' where dots can be matched with any letter.

solution
---------------------------------------------------------
same as trie basic
if there is dot - we just go to all possible children
 and check if any one possibility is true
we call dfs with each non null child
we pass startInd which is current index of word to dfs
if dot is there - just increment the word index

we pass root to dfs as we want to initialize current with root
we pass the word to search and we pass the current wordIndex

 */
fun main() {
    val myDictionary = WordDictionaryDot()
    myDictionary.addWord("karan")
    myDictionary.search("kara.").let { println(it) }
}
class TrieNode{
    var children = Array<TrieNode?>(26){null}
    var isWord = false
}
class WordDictionaryDot {
    private val root = TrieNode()

    fun addWord(word: String) {
        var curr = root
        for(ch in word){
            if(curr.children[ch - 'a'] == null){
//                println("adding alphabet "+ch)
                curr.children[ch - 'a'] = TrieNode()
            }
            curr = curr.children[ch - 'a']!!
        }
        curr.isWord = true
    }

    fun search(word: String): Boolean {
        return dfs(root,word,0)
    }
    fun dfs(root:TrieNode?,word:String,startInd:Int):Boolean{
        var current = root?:return false
        for(i in startInd until word.length){
            val ch:Char = word[i]
            when(ch){

                '.' ->{
                    for(child in current.children){
                        if(child != null && dfs(child,word,i+1))
                        return true

                    }
                   return false
                }
                else ->{
                    if(current.children[ch - 'a'] == null)
                        return false
                    current = current.children[ch - 'a']!!
                }

            }

        }
        return current.isWord
    }

}