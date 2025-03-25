import Trie.TrieNode
class TrieNode1{
    val children = HashMap<Char, TrieNode1>()
    var isWord:Boolean = false
    fun addWord(input:String){
        var curr = this
        for(c in input){
            curr = curr.children.getOrPut(c){TrieNode1() }
        }
        curr.isWord = true
    }
}
class Solution{
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode1()
        for (w in words){
            root.addWord(w)
        }
        val rows = board.size
        val cols = board[0].size
        val res = HashSet<String>()
        val visit = HashSet<Pair<Int,Int>>()
        fun dfs(r:Int,c:Int,trieNode:TrieNode1,wordSoFar:String){
            if(r !in board.indices || c !in board[0].indices || (r to c) in visit || board[r][c] !in trieNode.children)
                return
            visit.add(r to c)
            val wordSoFar = wordSoFar + board[r][c]
            val trieNode = trieNode.children[board[r][c]]!!
            if(trieNode.isWord){
                res.add(wordSoFar)
                trieNode.isWord = false
            }
            //up
            dfs(r - 1, c, trieNode,wordSoFar)
            //down
            dfs(r + 1, c, trieNode,wordSoFar)
            //left
            dfs(r, c - 1, trieNode,wordSoFar)
            //right
            dfs(r, c + 1, trieNode,wordSoFar)
            visit.remove(r to c)
        }
        for(r in board.indices)
            for(c in board[0].indices){
                dfs(r,c,root,"")
            }
        return res.toList()
    }
}