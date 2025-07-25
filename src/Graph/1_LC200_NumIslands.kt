package Graph
/*
LC200
https://leetcode.com/problems/number-of-islands/description/
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands
horizontally or vertically. You may assume all four edges
of the grid are all surrounded by water.

--- Big Idea ---

How will you group an island together :
you will mark it with 0's by flood fill algo
you will traverse with dfs to do this

💡 Analogy:
Think of a map with land and water.
 Every time you spot a piece of land not part of a known island,
 you start exploring and marking it off. That exploration is the DFS/BFS.

✅ Why DFS/BFS?
They help you group connected nodes (cells),
 just like you group connected components in a graph.

 🧠 Big Idea:
Traverse the grid. Every time you find a '1', it's a new island.
Then, do DFS or BFS to mark all connected '1's as visited.

So:

You treat the grid as a graph.

When you find an unvisited '1', it's the start of a new island.

You "flood-fill" the island (mark all its parts as visited) using DFS or BFS.

🔄 How It Works:
Loop through each cell in the grid.

When you find '1', increment island count.

Call DFS/BFS to visit and mark all connected land as '0' or visited.

Repeat until the whole grid is processed.

🛠️
implementation
for each cell:
whenever you see a 1 {
start dfs
increment num islands
}

dfs marks each island with a 0 with flood fill

 */
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
       intArrayOf(1,0), //bottom
       intArrayOf(-1,0),//top
       intArrayOf(0,1),//right
       intArrayOf(0,-1) //left
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