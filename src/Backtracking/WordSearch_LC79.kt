package Backtracking

class WordSearch_LC79 {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val totalRows = board.size
        val totalCols = board[0].size
        fun dfs(x:Int,y:Int,index:Int):Boolean{
            //💀 if we dont add below line and return true at end - whole word is not matched
            if (index == word.length) return true
            if(x !in board.indices || y !in board[0].indices || board[x][y] != word[index])
                return false
            val temp = board[x][y]
            board[x][y] = '#'
            //left
            val found = dfs(x,y-1,index+1) ||
            //right
            dfs(x,y+1,index+1) ||
            //up
            dfs(x - 1,y,index+1) ||
            //down
            dfs(x + 1,y,index+1)
            board[x][y] = temp
            return found
        }
        for (i in 0 until totalRows){
            for(j in 0 until totalCols){
                if(board[i][j] == word[0]){
                    if(dfs(i,j,0))
                        return true
                }
            }
        }
        return false
    }
}