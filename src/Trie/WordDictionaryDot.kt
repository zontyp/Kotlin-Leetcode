package Trie

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