package Recursion
/*LC51
we place queen on each column of a row and check if we can find
required position
we place on first row and check , then on next row and so on
we come to know only by placing the queen , checking and backtracking

dfs / solve checks for each row
and fow loop checks for each column

🧠 Big Picture First
The idea is to:

Try placing a queen row by row, one in each row.

For every position in the current row, check if placing a queen there is safe.

If yes, place it and go to the next row.

If not,backtrack and  try the next column.

When you reach currRow == totalRowCol,
 it means you’ve successfully placed N queens → record the board state as a solution.
 */
fun main() {
    val totalRowCol = 5
    val board = Array(totalRowCol){CharArray(totalRowCol){'.'} }
    NQueens().solve(0,board)
}
class NQueens {
    var result:MutableList<String> = mutableListOf()
    var totalRowCol = 5
    fun isSafe(board:Array<CharArray>,currRow: Int,currCol:Int):Boolean{
      //check column safety
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
                //After recursive call, backtrack (remove queen) to explore other options.
            board[currRow][currCol] = '.'
        }
    }
}
}