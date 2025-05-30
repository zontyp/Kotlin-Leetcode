/*
this can be done like LC 79 , word search but it is inefficient to check entire board for each word from .
the list of words
so we use trie along with backtracking to make word search happen in o(1)
for each cell of the board we check the entire trie (means all words)
in trie - checking if target word is present in a list of words is O(1) time
so from each cell of the board we search all words of input word list
 */
fun main() {
    val board = arrayOf(
        charArrayOf('o', 'a', 'a', 'n'),
        charArrayOf('e', 't', 'a', 'e'),
        charArrayOf('i', 'h', 'k', 'r'),
        charArrayOf('i', 'f', 'l', 'v')
    )
    val words = arrayOf("oath", "pea", "eat", "rain")
    val result = findWords(board, words)
    println("Words found: $result")
}

class TrieNode2{
    val children = HashMap<Char,TrieNode2>()
    var isWord:Boolean = false
    fun addWord(inputWord:String){
        var curr = this
        for (ch in inputWord){
            curr = curr.children.getOrPut(ch,{TrieNode2()})
        }
        curr.isWord = true
    }
}
fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val root = TrieNode2()
    val res = mutableListOf<String>()
    val visit = HashSet<Pair<Int,Int>>()
    for(word in words){
        root.addWord(word)
    }
    fun dfs(x:Int,y:Int,node:TrieNode2,wordSoFar:String){
        //out of bounds
        if(x !in board.indices || y !in board[0].indices || (x to y) in visit || board[x][y] !in node.children)
            return


        val newNode = node.children[board[x][y]]!!
        val newWord = wordSoFar + board[x][y]
        //positive base case
        if(newNode.isWord){
            res.add(newWord)
            newNode.isWord = false
        }
        visit.add(x to y)
        dfs(x-1,y,newNode,newWord)
        dfs(x+1,y,newNode,newWord)
        dfs(x,y-1,newNode,newWord)
        dfs(x,y+1,newNode,newWord)
        visit.remove(x to y)
    }

    for(i in 0 until board.size){
        for(j in 0 until board[0].size){
            if(board[i][j] in root.children)
                dfs(i,j,root,"")
        }
    }
    return res
}