/*
for each index on the board , we check for a match
if we get a match - we proceed to test the next character match.
move in all four directions as word can be anywhere.
base case is if we reach the end of the word
 */

fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )
    val word = "ABCCED"
    val result = exist(board, word)
    println("Does the word exist? $result")
}

fun exist(board: Array<CharArray>, word: String): Boolean {

    fun dfs(x:Int,y:Int,wordindex:Int):Boolean{
        //base case
        if(wordindex == word.length)
            return true

        //out of bounds case
        if(x !in board.indices || y !in board[0].indices || board[x][y] != word[wordindex])
            return false
        //track visited cells start
        val temp = board[x][y]
        board[x][y] = '#'
        //track visited cells end
        val found = dfs(x-1,y,wordindex + 1) ||
                dfs(x+1,y,wordindex + 1) ||
                dfs(x,y-1,wordindex + 1)||
                dfs(x,y+1,wordindex + 1)
        //backtrack - return board to original as dfs will be initiated for each cell of board
        board[x][y] = temp
        return found
    }
    for(i in 0 until board.size) {
        for (j in 0 until board[0].size) {
            if (dfs(i, j, 0))
                return true
        }
    }
    return false
}