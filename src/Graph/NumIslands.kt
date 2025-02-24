package Graph

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '0', '0'),
        charArrayOf('1', '1', '0', '0'),
        charArrayOf('0', '0', '1', '0'),
        charArrayOf('0', '0', '0', '1')
    )
    NumIslands().numIslands(grid).let{ println(it) }
}
class NumIslands {
   private val directions = arrayOf(
       intArrayOf(1,0),intArrayOf(-1,0),
       intArrayOf(0,1),intArrayOf(0,-1)
   )
    fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0

        if(grid.size == 0) return 0
        for(r in 0 until grid.size){
            for(c in 0 until grid[0].size){
                if(grid[r][c] == '1'){
                    dfs(grid,r,c)
                    islands++
            }
        }
    }
        return islands
}
    fun dfs(grid:Array<CharArray>,r:Int,c:Int){
        if(r !in grid.indices || c !in grid[0].indices || grid[r][c] == '0')
            return
        grid[r][c] = '0'
        for(dir in directions){
            dfs(grid,r+dir[0],c+dir[1])
        }

    }
}