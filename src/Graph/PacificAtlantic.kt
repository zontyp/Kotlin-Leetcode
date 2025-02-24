package Graph

fun main() {
    val a = arrayOf(
        intArrayOf(1,2,2,3,5),
        intArrayOf(3,2,3,4,4),
        intArrayOf(2,4,5,3,1),
        intArrayOf(6,7,1,4,5),
        intArrayOf(5,1,1,2,4)
    )
    PacificAtlantic().pacificAtlantic(a).let { println(it) }
}
class PacificAtlantic {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val totalRows = heights.size
        val totalCols = heights[0].size
        val pac = HashSet<Pair<Int,Int>>() // Pacific
        val atl = HashSet<Pair<Int,Int>>() // Atlantic
        fun dfs(
            r:Int,
            c:Int,
            visit:HashSet<Pair<Int,Int>>,
            prevHeight:Int
        ){
            val coord = r to c
            if(r < 0 || r >= totalRows ||c < 0 || c >= totalCols) return
            if(visit.contains(coord) || heights[r][c] < prevHeight) return
            visit.add(coord)
            dfs(r + 1, c, visit, heights[r][c])
            dfs(r - 1, c, visit, heights[r][c])
            dfs(r, c + 1, visit, heights[r][c])
            dfs(r, c - 1, visit, heights[r][c])
        }
        for(i in 0 until totalRows){
            dfs(i,0,pac,Int.MIN_VALUE)
            dfs(i,totalCols - 1,atl,Int.MIN_VALUE)
        }
        for(i in 0 until totalCols){
            dfs(0,i,pac,Int.MIN_VALUE)
            dfs(totalRows - 1,i,atl,Int.MIN_VALUE)
        }
        println(pac)
        println(atl)
        val commpnPairs =  pac.intersect(atl).toList()
        val result = mutableListOf<List<Int>>()
        for (thePair in commpnPairs){
            result.add(listOf(thePair.first,thePair.second))
        }
        return result
    }
}