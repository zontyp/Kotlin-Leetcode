package Recursion

fun main() {
    val totalRowCol = 5
    val board = Array(totalRowCol){CharArray(totalRowCol){'.'} }
    NQueens().solve(0,board)
}
class NQueens {
    var result:MutableList<String> = mutableListOf()
    var totalRowCol = 5
    fun isSafe(board:Array<CharArray>,currRow: Int,currCol:Int):Boolean{
        for (i in 0 until currRow){
            if(board[i][currCol] == 'Q')
                return false
        }
        var i = currRow - 1
        var j = currCol - 1
        //upper left diagonal
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                return false
            }
            i--
            j--
        }
        i = currRow - 1
        j = currCol + 1
        //upper right diagonal
        while(i >= 0 && j < totalRowCol){
            if(board[i][j] == 'Q'){
                return false
            }
            i--
            j++
        }
        return true
    }
    fun solve(currRow:Int,board:Array<CharArray>){
        if(currRow == totalRowCol){
            result = board.map{String(it)}.toMutableList()
            println(result)
            return
        }
        for(currCol in 0 until totalRowCol){
            if(isSafe(board,currRow,currCol)){
            board[currRow][currCol] = 'Q'
            solve(currRow +1,board)
            board[currRow][currCol] = '.'
        }
    }
}
}