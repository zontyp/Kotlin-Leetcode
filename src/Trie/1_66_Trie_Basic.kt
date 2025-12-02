package Trees
/*
we start with a root TrieNode
each node has a map
the map has char,node
so rootnode has all possible first alphabets of stored words
each of these alphabets maps to a node -
which contains all possible second alphabets after the selected first alphabet
 */
class `1_66_Trie_Basic` {
    private class TrieNode{
        var isWord = false
        val children:MutableMap<Char, TrieNode> = mutableMapOf()
    }
    private val root = TrieNode()
    fun insert(word:String){
        var current = root
        for(c in word){
            current = current.children.computeIfAbsent(c){ TrieNode() }
        }
        current.isWord = true
    }

    fun search(word:String):Boolean{
        var current = root
        for(c in word){
            current = current.children[c]?:return false
        }
        return current.isWord
    }
}